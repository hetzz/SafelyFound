from flask import Flask, request, jsonify
import threading
from . import facerecog
import os
import base64


app = Flask(__name__) 

port = '5000' 
ct =0

UPLOAD_FOLDER = 'knownfaces'
ALLOWED_EXTENSIONS = set(['png', 'jpg', 'jpeg'])

app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER

def allowed_file(filename):
    return '.' in filename and filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS

@app.route('/start', methods = ['POST'])
def index():
    print('request received', request.remote_addr)
    #print(request.get_json( )['name'], request.get_json( )['age'])
    print(request.get_json())
    facerecog.stop=False
    global ct
    t1 = threading.Thread(target=facerecog.main, args=[ct])
    t1.start()
    ct+=1
    d = {'type':'text', 'loc':'Delhi'}
    return jsonify(d)


@app.route('/stop', methods = ['GET','POST'])
def stop():
    facerecog.stop = True
    
    return jsonify({'stopped': True})

import struct

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
    # print(request.get_json())
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
    jreq = request.get_json()
    filename = jreq['filename']
    os.remove(os.path.join(app.config['UPLOAD_FOLDER'], filename))

if __name__ == "__main__":
    app.run(port=port)