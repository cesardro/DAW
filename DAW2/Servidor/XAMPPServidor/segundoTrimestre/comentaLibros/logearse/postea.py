#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

from configuracion import configBD
import codigoHTML
import os
from http import cookies
import mysql.connector
from regOperaciones import regTiempos

proceder = False

mydb = mysql.connector.connect(
    host=configBD["host"],
    user=configBD["user"],
    password=configBD["password"],
    database=configBD["database"]
)

mycursor = mydb.cursor()
mycursor.execute("SELECT usuario, id FROM usuarios")
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
            regTiempos("postea.py", "cookie="+todasCokis['SID'], datos[1])

if proceder:
    print("Content-Type: text/html\n")
    print(codigoHTML.cabeceraHTML.format("Posteando", "", "Postea tu libro"))
    print(codigoHTML.postea)
else:
    print("Content-Type: text/html\n")
    print(codigoHTML.cabeceraHTML.format(
        "", '<meta http-equiv="Refresh" content="0; URL=../error.html"/>', ""))
    print(codigoHTML.finalHTML)
