import requests
import numpy as np
import time
import threading
import facerecogsub
import json

def wsid():
    started = False
    t1 = None
    ct = 0
    clientstat = 'new'
    clientid = -1
    headers = {'Content-Type': 'application/json', 'accept': 'application/json'}
    while True:
        send_data = {'clientstat':clientstat, 'clientid':clientid}
        try:
            r = requests.post(url = "https://oopmproj4751.localtunnel.me/wsid", data = json.dumps(send_data), headers=headers) 
            data = r.json()
        except:
            r = requests.post(url = "https://oopmproj4751.localtunnel.me/wsid", data = json.dumps(send_data), headers = headers) 
            data = r.json()
        if clientid == -1:
            clientid = data['clientid']
        if data['wsid'] == 'start' and not started:
            print('starting sub processing')
            known_face_encodings = data['encodings']
            known_face_names = data['names']
            for i in range(len(known_face_encodings)):
                known_face_encodings[i]=np.array(known_face_encodings[i])
            
            started = True
            facerecogsub.stop = False
            clientstat = 'running'
            t1 = threading.Thread(target=facerecogsub.main, args=[ct, known_face_encodings, known_face_names])
            t1.start()
            ct += 1
            
        elif data['wsid'] == 'stop' and started:
            print('stopping sub processing')
            facerecogsub.stop = True
            t1.join()
            started = False
            clientstat = 'stopped'
        elif data['wsid'] == 'stop' and clientstat == 'new':
            started = False
            clientstat = 'stopped'
        time.sleep(2)

wsid()
