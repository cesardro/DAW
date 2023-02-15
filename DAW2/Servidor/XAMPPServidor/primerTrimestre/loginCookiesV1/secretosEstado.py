#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import CodigoHTML, os
from http import cookies

print("Content-Type: text/html\n")

usuarios = {"pepe": ["1234", "asdf1234"], "maria": ["1111", "oinioh32145"]}
estasDentro = False

todasCokis = {}
if 'HTTP_COOKIE' in os.environ:
    listaCoki = os.environ['HTTP_COOKIE']
    listaCoki = listaCoki.split('; ')

    for elemCoki in listaCoki:
        (nombre, valor) = elemCoki.split('=')
        todasCokis[nombre] = valor

agente = ""

if 'SID' in todasCokis:
    for agen,datos in usuarios.items():
        if(datos[1] == todasCokis[nombre]):
            estasDentro = True
            agente = agen

if estasDentro:
    print(CodigoHTML.cabeceraHTML.format("CNI", "Secretos de Estado"))
    print("<h3 class='Display-3'>Bienvenido, agente " + agente + "</h3>")
    print("<a href='login.py'>Volver</a><br>")
    print("<a href='logout.py'>Salir</a><br>")
    print(CodigoHTML.finalHTML)
else:
    print(CodigoHTML.cabeceraHTML.format("CNI", "Error en el acceso"))
    print("<a href='index.html'>Página de acceso</a><br>")
    print(CodigoHTML.finalHTML)