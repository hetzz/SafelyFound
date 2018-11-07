from flask import Flask, request, jsonify
import threading
from . import facerecog
import os
import base64
import struct

app = Flask(__name__) 

port = '5000' 
ct =0

UPLOAD_FOLDER = 'knownfaces'
ALLOWED_EXTENSIONS = set(['png', 'jpg', 'jpeg'])

app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER
facerecog.stop = True

clients = []
updated = []

def allowed_file(filename):
    return '.' in filename and filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS

@app.route('/start', methods = ['POST'])
def index():
    print('request received', request.remote_addr)
    d = {'acr':'rejected'}
    print(request.get_json())
    if facerecog.stop == False:
        return jsonify(d)
    facerecog.stop=False
    global ct
    t1 = threading.Thread(target=facerecog.main, args=[ct])
    t1.start()
    ct+=1
    d['acr']= 'accepeted'
    return jsonify(d)


@app.route('/stop', methods = ['POST'])
def stop():
    facerecog.stop = True
    global updated
    updated = [False]*len(updated)
    return jsonify({'stopped': True})



def rawbytes(s):
    """Convert a string to raw bytes without encoding"""
    outlist = []
    for cp in s:
        num = ord(cp)
        if num < 255:
            outlist.append(struct.pack('b', num))
        elif num < 65535:
            outlist.append(struct.pack('>H', num))
        else:
            b = (num & 0xFF0000) >> 16
            H = num & 0xFFFF
            outlist.append(struct.pack('>bH', b, H))
    return b''.join(outlist)

@app.route('/gpr', methods = ['POST'])
def fileup():
    print('request received  file')
    
    d = {'type':'text', 'uploaded':'true'}
    jreq = request.get_json()
    filename = ''.join(jreq['name'].split())
    filename += '.'+jreq['extension']
    img_data = jreq['file']
    with open(os.path.join(app.config['UPLOAD_FOLDER'], filename), "wb") as fh:
        fh.write(base64.decodebytes(rawbytes(img_data)))
    
    d['filename'] = filename
    return jsonify(d)

@app.route('/delete', methods = ['POST'])
def delete_record():
    d = {'acr':'rejected'}
    jreq = request.get_json()
    filename = jreq['filename']
    try:
        os.remove(os.path.join(app.config['UPLOAD_FOLDER'], filename))
        d['acr']='accepted'
    except:
        return jsonify(d)
    
    return jsonify(d)

def decideStartStop(d):
    if not facerecog.started:
            d['wsid'] = 'stop'
    else:
        d['wsid']='start'
        frke = []
        for e in facerecog.known_face_encodings:
            frke.append(e.tolist())
        d['encodings']=frke
        d['names'] = facerecog.known_face_names
        d['length'] =len(facerecog.known_face_names)

@app.route('/wsid', methods = ['POST'])
def wsid():
    d = {}
    jreq = request.get_json()
    print(jreq)
    if jreq['clientstat'] == 'new':
        newcid = len(clients)
        clients.append(newcid)
        updated.append(True)
        d['clientid'] = newcid
        decideStartStop(d)
    elif jreq['clientstat'] == 'stopped':
        decideStartStop(d)
        updated[jreq['clientid']] = True
    elif jreq['clientstat'] == 'running':
        if not updated[jreq['clientid']]:
            d['wsid'] = 'stop'
            updated[jreq['clientid']] = True
        else:
            decideStartStop(d)
    # print(d)
    return jsonify(d)


if __name__ == "__main__":
    app.run(port=port)