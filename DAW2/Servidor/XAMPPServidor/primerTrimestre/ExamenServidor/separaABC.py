#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import os
from http import cookies
import cgi

args = cgi.parse()

try:
    texto = args['texto'][0]
except:
    texto = ''

todasCokis = {}
if 'HTTP_COOKIE' in os.environ:
    listaCoki = os.environ['HTTP_COOKIE']
    listaCoki = listaCoki.split('; ')

    for elemCoki in listaCoki:
        (nombre, valor) = elemCoki.split('=')
        todasCokis[nombre] = valor

coki = cookies.SimpleCookie()

if '' == texto:
    coki["empiezaABC"] = ''
    coki["otras"] = ''
else:
    if texto[0] == 'A' and texto[1] == 'B' and texto[2] == 'C':
        if 'empiezaABC' in todasCokis:
            coki["empiezaABC"] = todasCokis["empiezaABC"] + ' ' + texto
        else:
            coki["empiezaABC"] = texto
    else:
        if 'otras' in todasCokis:
            coki["otras"] = todasCokis["otras"] + ' ' + texto
        else:
            coki["otras"] = texto

print(coki)

print("Content-Type: text/text\n")
