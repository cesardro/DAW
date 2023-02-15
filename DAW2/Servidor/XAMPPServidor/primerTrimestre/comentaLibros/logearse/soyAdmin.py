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

mycursor.execute("SELECT * FROM usuarios")
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
        if (datos[2] == todasCokis['SID']):
            proceder = True

if proceder:
    print("Content-Type: text/html\n")
    print(codigoHTML.cabeceraHTML.format("Admin", "", "Bienvenido ADMIN"))

    for x in myresult:
        print(codigoHTML.soyAdminHTML.format('<tr><td>' + x[1] + '</td>'))
        if x[4] == 1:
            print('<td>Si</td>')
            print('<td>No disponible</td>')
        else:
            print('<td>No</td>')
            print('<td><form action="borrar.py" method="post">')
            print('<button type="submit" class="btn btn-primary">Borrar</button>')
            print('<input type="hidden" name="idUsuario" value="' +
                  str(x[0])+'">')
            print('</form></td>')
        print('</tr>')
    print('</table>')
    print('<form action="logout.py" method="get"><button type="submit" class="btn btn-primary">Log out</button></form>')
    print(codigoHTML.finalHTML)

else:
    print("Content-Type: text/html\n")
    print(codigoHTML.cabeceraHTML.format(
        "", '<meta http-equiv="Refresh" content="0; URL=../error.html"/>', ""))
    print(codigoHTML.finalHTML)
