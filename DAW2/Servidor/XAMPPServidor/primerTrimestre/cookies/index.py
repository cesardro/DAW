#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

from http import cookies
import CodigoHTML
import os

todasCokis = {}
if 'HTTP_COOKIE' in os.environ:
    listaCoki = os.environ['HTTP_COOKIE']
    listaCoki = listaCoki.split('; ')

    for elemCoki in listaCoki:
        (nombre, valor) = elemCoki.split('=')
        todasCokis[nombre] = valor

coki = cookies.SimpleCookie()
coki["contador"] = 0
coki["nombre"] = "yomismoconmimecanismo"
print(coki)

print("Content-Type: text/html\n")

# Inicio del código HTML
print(CodigoHTML.cabeceraHTML.format("Cookies", "Cookies"))

print(todasCokis)

# Fin del código HTML
print(CodigoHTML.finalHTML)
