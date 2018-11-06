import requests
import numpy as np
import time
import threading
import facerecogsub
def wsid():
    started = False
    t1 = None
    ct = 0
    while True:
        r = requests.post(url = "https://oopmproj4751.localtunnel.me/wsid") 
        data = r.json()
        if data['wsid'] == 'start' and not started:
            print('starting sub processing')
            known_face_encodings = data['encodings']
            known_face_names = data['names']
            for i in range(len(known_face_encodings)):
                known_face_encodings[i]=np.array(known_face_encodings[i])
            t1 = threading.Thread(target=facerecogsub.main, args=[known_face_encodings, known_face_names, ct])
            ct += 1
        elif data['wsid'] == 'stop' and started:
            print('stopping sub processing')
            facerecogsub.stop = True
            t1.join()
            started = False
        time.sleep(2)

wsid()