#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import cgi
import json
print("Content-Type: text/plain\n")


args = cgi.parse()

datos = []

datos.append(args["palabra"][0])

f = open("datos/listado.json", "rt")
listado = json.loads(f)
print(listado)
f.write(json.dumps(datos))
f.close()