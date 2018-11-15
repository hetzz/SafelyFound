import face_recognition
import cv2
import time
import os
import re
import lseen
import numpy as nmp
from importlib import reload
MOD = 5


stop = False


def dostuff(video_capture, known_face_names, known_face_encodings, ct, mobcam = False, count = 0):
    face_locations = []
    face_encodings = []
    face_names = []
    
    if mobcam:
        ratio = 0.4
    else:
        ratio = 0.5
    ratinv = 1/ratio
    tolerance = 0.5
    while not stop:
        # Grab a single frame of video
        # print('running')
        ret, frame = video_capture.read()
        
        if count % MOD == 0:
            small_frame = cv2.resize(frame, (0, 0), fx=ratio, fy=ratio)
            
            rgb_small_frame = small_frame[:, :, ::-1]

            
            face_locations = face_recognition.face_locations(rgb_small_frame)
            face_encodings = face_recognition.face_encodings(rgb_small_frame, face_locations)

            face_names = []
            for face_encoding in face_encodings:
                # matches = face_recognition.compare_faces(known_face_encodings, face_encoding, tolerance=tolerance)
                distances = face_recognition.face_distance(known_face_encodings, face_encoding)
                matches = list(distances <= tolerance)
                
                name = "Unknown"
                stored = False
                if True in matches:
                    match_index = (nmp.argmin(distances, axis=0))
                    print(distances)
                    print(known_face_names)
                    # first_match_index = matches.index(True)
                    name = known_face_names[match_index]
                    
                    if lseen.store(name):
                        stored = True
                face_names.append(name)
                print(name)
            

            for (top, right, bottom, left), name in zip(face_locations, face_names):
                
                top *= ratinv
                right *= ratinv
                bottom *= ratinv
                left *= ratinv

                top = int(round(top, 0))
                right = int(round(right, 0))
                left = int(round(left, 0))
                bottom = int(round(bottom, 0))

                cv2.rectangle(frame, (left, top), (right, bottom), (0, 255, 0), 2)

                cv2.rectangle(frame, (left, bottom - 35), (right, bottom), (0, 255, 0), cv2.FILLED)
                font = cv2.FONT_HERSHEY_DUPLEX
                cv2.putText(frame, name, (left + 6, bottom - 6), font, 1.0, (255, 255, 255), 1)
                if stored and name != 'Unknown':
                    cv2.imwrite('finds\\'+ '_'.join(name.split())+'-'+'_'.join(str(lseen.lastseendict[name][-1][0]).split())+'.jpg', frame )
            if ct == 0:
                cv2.imshow('Video', frame)
            
            
        # Hit 'q' on the keyboard to quit!
        if ct == 0:
            if cv2.waitKey(1) & 0xFF == ord('q'):
                break
        else:
            time.sleep(.005)
        count += 1
    video_capture.release()
    cv2.destroyAllWindows()
def main(ct, known_face_encodings, known_face_names):
    reload(lseen)
    lseen.openconnection()
    mobcam = False
    if mobcam:
        # address = 'http://192.168.15.184:8080/video'
        address = 'http://192.168.15.118:8080/video'
    else:
        address = 0
    video_capture = cv2.VideoCapture(address)
    dostuff(video_capture, known_face_names, known_face_encodings, ct, mobcam=mobcam)
    lseen.closeconnection()


if __name__ == "__main__":
    main(0)
