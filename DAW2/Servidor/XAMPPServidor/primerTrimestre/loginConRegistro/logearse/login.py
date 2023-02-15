#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

from genericpath import exists
from http import cookies
import cgi
import json
import os.path
import os
import datetime
import codigoHTML
import hashlib

args = cgi.parse()

datos = []

proceder = False

datos.append(args["name"][0])
#Encriptado de contraseñas
h=hashlib.sha512(str.encode(args["pswd"][0]))
datos.append(h.hexdigest())

try:

    if (os.path.exists("../registro/datos/listado.json")):

        f = open("../registro/datos/listado.json", "rt")
        datosEnJson = json.loads(f.read())
        f.close()

        for x in datosEnJson:
            nombre = x[0]
            pswd = x[1]

            if (nombre == datos[0] and pswd == datos[1]):
                proceder = True

        if (proceder):
            coki = cookies.SimpleCookie()
            coki["SID"] = pswd
            # Expira la cookie en 30 días.
            expires = datetime.datetime.utcnow() + datetime.timedelta(days=30)
            coki['SID']['expires'] = expires.strftime("%a, %d %b %Y %H:%M:%S GMT")
            print(coki)
            print("Content-Type: text/html\n")
            print(codigoHTML.cabeceraHTML.format("Logeado", '<meta http-equiv="Refresh" content="3; URL=pagina1.py"/>', "Logeado exitosamente. Redirigiendo a pagina."))
            print(codigoHTML.finalHTML)
        else:
            print(codigoHTML.cabeceraHTML.format("Registro fallado",
                  '<meta http-equiv="Refresh" content="3; URL=login.html"/>', "Usuario o Contraseña incorrectos. Intenta de nuevo."))
            print(codigoHTML.finalHTML)

    else:

        print(codigoHTML.cabeceraHTML.format(
            "", '<meta http-equiv="Refresh" content="0; URL=../error.html"/>', ""))
        print(codigoHTML.finalHTML)

except:
    print(codigoHTML.cabeceraHTML.format(
        "", '<meta http-equiv="Refresh" content="0; URL=../error.html"/>', ""))
    print(codigoHTML.finalHTML)
