#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import codigoHTML
import os
from http import cookies
import mysql.connector

proceder = False

mydb = mysql.connector.connect(
    host='localhost',
    user='comentaLibro',
    password='comentaLibro',
    database='comentaLibro'
)

mycursor = mydb.cursor()

mycursor.execute("SELECT usuario FROM usuarios")
myresult = mycursor.fetchall()

todasCokis = {}  # diccionario vacio
if 'HTTP_COOKIE' in os.environ:
    listaCoki = os.environ['HTTP_COOKIE']
    listaCoki = listaCoki.split(';')

    for elemCoki in listaCoki:
        (nombre, valor) = elemCoki.split('=')
        todasCokis[nombre] = valor

coki = cookies.SimpleCookie()

if 'SID' in todasCokis:
    for datos in myresult:
        if (datos[0] == todasCokis['SID']):
            proceder = True

if proceder:
    print("Content-Type: text/html\n")
    print(codigoHTML.cabeceraHTML.format("Posteando", "", "Postea tu libro"))
    print(codigoHTML.postea)
else:
    print("Content-Type: text/html\n")
    print(codigoHTML.cabeceraHTML.format(
        "", '<meta http-equiv="Refresh" content="0; URL=../error.html"/>', ""))
    print(codigoHTML.finalHTML)
