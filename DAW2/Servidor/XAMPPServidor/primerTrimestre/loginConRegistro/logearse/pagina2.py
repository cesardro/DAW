#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

from http import cookies
import codigoHTML
import json
import os

f = open("../registro/datos/listado.json", "rt")
datosEnJson = json.loads(f.read())
f.close()

proceder = False

todasCokis = {}  # diccionario vacio
if 'HTTP_COOKIE' in os.environ:
    listaCoki = os.environ['HTTP_COOKIE']
    listaCoki = listaCoki.split(';')

    for elemCoki in listaCoki:
        (nombre, valor) = elemCoki.split('=')
        todasCokis[nombre] = valor
      # todasCokis["SID"]="ASDFasdf344"

coki = cookies.SimpleCookie()

if 'SID' in todasCokis:
    for datos in datosEnJson:
        if (datos[1] == todasCokis['SID']):
            proceder = True

if proceder:
    print("Content-Type: text/html\n")
    print(codigoHTML.cabeceraHTML.format("Pagina 2", "", "PAGINA 2"))
    print(codigoHTML.pagina2HTML)
else:
    print(codigoHTML.cabeceraHTML.format(
        "", '<meta http-equiv="Refresh" content="0; URL=../error.html"/>', ""))
    print(codigoHTML.finalHTML)
