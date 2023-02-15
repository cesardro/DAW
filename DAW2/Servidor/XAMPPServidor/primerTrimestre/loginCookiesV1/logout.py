#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import CodigoHTML
import os
import datetime
from http import cookies

todasCokis = {}
if 'HTTP_COOKIE' in os.environ:
    listaCoki = os.environ['HTTP_COOKIE']
    listaCoki = listaCoki.split('; ')

    for elemCoki in listaCoki:
        (nombre, valor) = elemCoki.split('=')
        todasCokis[nombre] = valor

if 'SID' in todasCokis:
    coki = cookies.SimpleCookie()
    coki["SID"] = todasCokis["SID"]
    # Caduca la cookie.
    expires = datetime.datetime.utcnow() + datetime.timedelta(days=-1)
    coki['SID']['expires'] = expires.strftime("%a, %d %b %Y %H:%M:%S GMT")
    print(coki)

print("Content-Type: text/html\n")

print(CodigoHTML.redireccionIndex())