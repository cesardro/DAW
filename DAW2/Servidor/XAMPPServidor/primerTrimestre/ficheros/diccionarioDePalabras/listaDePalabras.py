#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import json
print("Content-Type: text/plain\n")

f = open("datos/listado.json", "rt")

datosEnJson = json.loads(f.read())
f.close()

tam = len(datosEnJson)

for x in range(tam):
    print(x,":",datosEnJson[x])

for element in datosEnJson:
    print(element[0],"----",element[1])