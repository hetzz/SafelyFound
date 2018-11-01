from flask import Flask, request, jsonify
import threading
from . import facerecog
from importlib import reload


app = Flask(__name__) 
port = '5000' 
ct =0
@app.route('/start', methods = ['POST'])
def index():
    print('request received')
    print(request.get_json( )['name'], request.get_json( )['age'])
    d = {'type':'text', 'loc':'Delhi'}
    facerecog.stop=False
    global ct
    t1 = threading.Thread(target=facerecog.main, args=[ct])
    t1.start()
    ct+=1
    return jsonify(d)


@app.route('/stop', methods = ['GET','POST'])
def stop():
    facerecog.stop = True
    
    return jsonify({'stopped': True})


@app.route('/gpr', methods = ['POST'])
def fileup():
    print('request received  file')
    print(request.files)
    d = {'type':'text', 'loc':'Delhi'}
    
    return jsonify(d)


if __name__ == "__main__":
    app.run(port=port)