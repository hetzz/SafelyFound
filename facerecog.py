import face_recognition
import cv2
import time
import click
import os
import re
from . import lastseen
import numpy as nmp

MOD = 5
known_people_folder = './knownfaces'
stop = False
def image_files_in_folder(folder):
    return [os.path.join(folder, f) for f in os.listdir(folder) if re.match(r'.*\.(jpg|jpeg|png)', f, flags=re.I)]

def scan_known_people(known_people_folder):
    known_names = []
    known_face_encodings = []

    for file in image_files_in_folder(known_people_folder):
        basename = os.path.splitext(os.path.basename(file))[0]
        img = face_recognition.load_image_file(file)
        encodings = face_recognition.face_encodings(img)

        if len(encodings) > 1:
            click.echo("WARNING: More than one face found in {}. Only considering the first face.".format(file))

        if len(encodings) == 0:
            click.echo("WARNING: No faces found in {}. Ignoring file.".format(file))
        else:
            known_names.append(basename)
            known_face_encodings.append(encodings[0])

    return known_names, known_face_encodings

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
                # See if the face is a match for the known face(s)
                
                # matches = face_recognition.compare_faces(known_face_encodings, face_encoding, tolerance=tolerance)
                distances = face_recognition.face_distance(known_face_encodings, face_encoding)
                matches = list(distances <= tolerance)
                
                name = "Unknown"
                stored = False
                # If a match was found in known_face_encodings, just use the first one.
                if True in matches:
                    match_index = (nmp.argmin(distances, axis=0))
                    print(distances)
                    print(known_face_names)
                    # first_match_index = matches.index(True)
                    name = known_face_names[match_index]
                    
                    if lastseen.store(name):
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
                    cv2.imwrite('./finds/'+ '_'.join(name.split())+'-'+'_'.join(str(lastseen.lastseendict[name][-1][0]).split())+'.jpg', frame )
            if ct == 0:
                cv2.imshow('Video', frame)
            
            
        # Hit 'q' on the keyboard to quit!
        if ct == 0:
            if cv2.waitKey(1) & 0xFF == ord('q'):
                break
        else:
            time.sleep(.005)
        count += 1
    # Release handle to the webcam
    video_capture.release()
    cv2.destroyAllWindows()
def main(ct):
    
    known_face_names, known_face_encodings = scan_known_people(known_people_folder)
    lastseen.openconnection()
    mobcam = False
    if mobcam:
        address = 'http://192.168.15.184:8080/video'
    else:
        address = 0
    video_capture = cv2.VideoCapture(address)
    dostuff(video_capture, known_face_names, known_face_encodings, ct, mobcam=True)
    print('hi')
    lastseen.closeconnection()


if __name__ == "__main__":
    main(0)
