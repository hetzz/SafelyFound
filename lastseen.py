import datetime
lastseendict = {}

def to_store_or_not(name):
    if lastseendict.get(name, None)!= None:
        diff = datetime.datetime.now() - lastseendict[name][-1][0] 
        c = divmod(diff.days * 86400 + diff.seconds, 60)
        if c[0] >= 1:
            return True
        else:
            return False
    return True

def store(name):
    if to_store_or_not(name):
        print(lastseendict.get(name, []))
        if lastseendict.get(name, None) == None:
            lastseendict[name] = [(datetime.datetime.now(), 'Mulund')]
        else:
            lastseendict[name].append((datetime.datetime.now(), 'Mulund'))
        

        print('stored', lastseendict)
        return True
    return False