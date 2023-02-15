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
    mycursor.execute(
        "SELECT titulo, imagen, comentario, usuario FROM comentarios INNER JOIN usuarios ON comentarios.usuarioId = usuarios.id")
    comentarios = mycursor.fetchall()
    print("Content-Type: text/html\n")
    print(codigoHTML.cabeceraHTML.format("Principal", "", "Foro de libros"))
    print("<form style='margin: 30px auto;' action='postea.py' method='post'><button type='submit' class='btn btn-primary'>Postea un libro</button></form>")
    print("<form action='logout.py' method='post'><button type='submit' class='btn btn-primary'>Logout</button></form>")
    print("<table class='table' style='text-align: center; padding: auto;'>")
    print("<tr>")
    print("<th>Libro</th>")
    print("<th>Comentario</th>")
    print("<th>Usuario</th>")
    print("</tr>")
    for x in comentarios:
        print(codigoHTML.interfaz.format(x[0], x[1], x[2], x[3]))
    print("</table>")
    print(codigoHTML.finalHTML)
else:
    print("Content-Type: text/html\n")
    print(codigoHTML.cabeceraHTML.format(
        "", '<meta http-equiv="Refresh" content="0; URL=../error.html"/>', ""))
    print(codigoHTML.finalHTML)
