#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import cgi
from genericpath import exists
import json
import os.path
import codigoHTML
import hashlib

print("Content-Type: text/html\n")

args = cgi.parse()

datos = []

proceder = False

try:

    datos.append(args["name"][0])
    #Encriptado de contraseñas
    h=hashlib.sha512(str.encode(args["pswd"][0]))
    datos.append(h.hexdigest())
    #Fin encriptado
    datos.append(args["email"][0])
    if (os.path.exists("datos/listado.json")):

        f = open("datos/listado.json", "rt")
        datosEnJson = json.loads(f.read())
        f.close()

        for x in datosEnJson:
            nombre = x[0]
            email = x[2]

            if (nombre == datos[0] or email == datos[2]):
                proceder = True

        if (proceder):
            print(codigoHTML.cabeceraHTML.format("Registro fallado",
                  '<meta http-equiv="Refresh" content="2; URL=../aplicacion.html"/>', "Usuario o correo duplicado. Redirigiendo"))
            print(codigoHTML.finalHTML)
        else:
            datosEnJson.append(datos)
            f = open("datos/listado.json", "wt")
            f.write(json.dumps(datosEnJson))
            f.close()
            print(codigoHTML.cabeceraHTML.format("Registro completado",
                  '<meta http-equiv="Refresh" content="2; URL=../aplicacion.html"/>', "Registro completado. Redirigiendo"))
            print(codigoHTML.finalHTML)
    else:

        f = open("datos/listado.json", "wt")
        f.write("[")
        f.write(json.dumps(datos))
        f.write("]")
        f.close()

except:
    print(codigoHTML.cabeceraHTML.format("",
          '<meta http-equiv="Refresh" content="0; URL=../error.html"/>', ""))
    print(codigoHTML.finalHTML)
