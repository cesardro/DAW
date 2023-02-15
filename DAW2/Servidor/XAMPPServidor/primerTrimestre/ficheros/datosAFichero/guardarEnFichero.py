#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import cgi
import json
print("Content-Type: text/plain\n")


args = cgi.parse()

datos = []

datos.append(args["nombre"][0])
datos.append(args["edad"][0])

f = open("datos/listado.json", "a")
# Transforma a JSON.
f.write(json.dumps(datos))
f.close()
