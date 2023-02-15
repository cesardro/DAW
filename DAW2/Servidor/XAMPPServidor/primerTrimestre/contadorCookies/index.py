#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import codigoHTML
import os
from http import cookies

todasCokis = {}
if 'HTTP_COOKIE' in os.environ:
    listaCoki = os.environ['HTTP_COOKIE']
    listaCoki = listaCoki.split("; ")

    for elemCoki in listaCoki:
        (nombre, valor) = elemCoki.split("=")
        todasCokis[nombre] = valor

# Se ejecuta solo la primera vez que accede el usuario.
coki = cookies.SimpleCookie()

if 'contador' in todasCokis:
    coki["contador"] = int(todasCokis["contador"])+1
else:
    coki["contador"] = 1

print(coki)

print("Content-Type: text/html\n")

print(codigoHTML.cabeceraHTML.format("Titulo", "Contador con cookies"))
print(todasCokis)
print(codigoHTML.finalHTML)
