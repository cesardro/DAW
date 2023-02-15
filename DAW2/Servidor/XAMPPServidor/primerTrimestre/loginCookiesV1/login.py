#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import cgi
import os
import datetime
import CodigoHTML
from http import cookies


usuarios = {"pepe": ["1234", "asdf1234"], "maria": ["1111", "oinioh32145"]}

args = cgi.parse()
user = args['user'][0]
passwd = args['pass'][0]
estaDentro = False

if user in usuarios:
    if usuarios[user][0] == passwd:
        estaDentro = True

if estaDentro:
    coki = cookies.SimpleCookie()
    coki["SID"] = usuarios[user][1]
    # Expira la cookie en 30 días.
    expires = datetime.datetime.utcnow() + datetime.timedelta(days=30)
    coki['SID']['expires'] = expires.strftime("%a, %d %b %Y %H:%M:%S GMT")
    print(coki)

print("Content-Type: text/html\n")

if estaDentro:
    print(CodigoHTML.cabeceraHTML.format("CNI", "Entrada al CNI"))
    print("<h6 class='Display-6'>Estas dentro</h6>")
    print("<a href='secretosEstado.py'>Secretos de Estado</a><br>")
    print("<a href='secretosEmerito.py'>Secretos del Emerito</a><br>")
else:
    print(CodigoHTML.redireccionError)

print(CodigoHTML.finalHTML)