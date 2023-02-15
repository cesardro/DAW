#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

from configuracion import configBD
import codigoHTML
import os
from http import cookies
import mysql.connector
from regOperaciones import regTiempos
import cgi

proceder = False

args = cgi.parse()
idUser = args["idUsuario"][0]

mydb = mysql.connector.connect(
    host=configBD["host"],
    user=configBD["user"],
    password=configBD["password"],
    database=configBD["database"]
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
        if (datos[1] == todasCokis['SID']):
            proceder = True

if proceder:
    print("Content-Type: text/html\n")

    mycursor.execute("SELECT regoperaciones.id, regoperaciones.usuarioId, regoperaciones.operacion, regoperaciones.parametros, regoperaciones.tmpAccion, usuarios.usuario FROM regoperaciones INNER JOIN usuarios ON regoperaciones.usuarioId = usuarios.id AND usuarios.id="+idUser)
    myresult = mycursor.fetchall()

    print(codigoHTML.cabeceraHTML.format(
        "Historial", "", "Historial de Operaciones de: "+str(myresult[0][5])))

    regTiempos("historial.py", "personaRevisada=" + str(myresult[0][5]), 1)

    print(codigoHTML.historialAdminHTML)
    for x in range(0, len(myresult)):
        print('<tr>')
        print('<td>'+str(myresult[x][0])+'</td>')
        print('<td>'+str(myresult[x][1])+'</td>')
        print('<td>'+str(myresult[x][2])+'</td>')
        print('<td>'+str(myresult[x][3])+'</td>')
        print('<td>'+str(myresult[x][4])+'</td>')
        print('</tr>')
    print('</table>')
    print('<form action="soyAdmin.py" method="post"><button type="submit" class="btn btn-primary">Atras</button></form><br>')
    print('<form action="logout.py" method="post"><button type="submit" class="btn btn-primary">Log out</button></form>')
    print(codigoHTML.finalHTML)

else:
    print("Content-Type: text/html\n")
    print(codigoHTML.cabeceraHTML.format(
        "", '<meta http-equiv="Refresh" content="0; URL=../error.html"/>', ""))
    print(codigoHTML.finalHTML)
