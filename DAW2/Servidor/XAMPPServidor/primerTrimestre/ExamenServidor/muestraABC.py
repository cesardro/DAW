#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import os
from http import cookies

todasCokis = {}  # diccionario vacio
if 'HTTP_COOKIE' in os.environ:
    listaCoki = os.environ['HTTP_COOKIE']
    listaCoki = listaCoki.split(';')

    for elemCoki in listaCoki:
        (nombre, valor) = elemCoki.split('=')
        todasCokis[nombre] = valor

coki = cookies.SimpleCookie()

print("Content-Type: text/html\n")
print("""
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Ejercicio 1</title>
        </head>

        <body>
        """)
print("<p>Palabras que empiezan por ABC:")
print(todasCokis["empiezaABC"])
print("</p>")
print("<p>Palabras que no empiezan por ABC:")
print(todasCokis[" otras"])
print("</p>")
print("""
        </body>
        </html>
        """)
