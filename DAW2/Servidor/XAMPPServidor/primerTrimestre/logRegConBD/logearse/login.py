#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

from genericpath import exists
from http import cookies
import cgi
import os
import datetime
import codigoHTML
import hashlib
import mysql.connector

args = cgi.parse()

proceder = False
soyAdmin = False

mydb = mysql.connector.connect(
    host='localhost',
    user='logRegConBD',
    password='logRegConBD',
    database='logRegConBD'
)

mycursor = mydb.cursor()

name = args["name"][0]
# Encriptado de contraseñas
pswd = hashlib.sha512(str.encode(args["pswd"][0]))
pswd = (pswd.hexdigest())

try:

    mycursor.execute("SELECT * FROM logRegConBD where name='" + name + "'")

    myresult = mycursor.fetchall()

    for x in myresult:
        if (name == x[1] and pswd == x[2]):
            proceder = True
        if (x[4] == 1):
            soyAdmin = True

    if proceder:
        coki = cookies.SimpleCookie()
        coki["SID"] = pswd
        # Expira la cookie en 30 días.
        expires = datetime.datetime.utcnow() + datetime.timedelta(days=30)
        coki['SID']['expires'] = expires.strftime(
            "%a, %d %b %Y %H:%M:%S GMT")
        print(coki)

        if soyAdmin:
            print("Content-Type: text/html\n")
            print(codigoHTML.cabeceraHTML.format(
                "Logeado", '<meta http-equiv="Refresh" content="3; URL=soyAdmin.py"/>', "Bienvenido Administrador, redirigiendo..."))
            print(codigoHTML.finalHTML)
        else:
            print("Content-Type: text/html\n")
            print(codigoHTML.cabeceraHTML.format(
                "Logeado", '<meta http-equiv="Refresh" content="3; URL=pagina1.py"/>', "Logeado exitosamente. Redirigiendo a pagina."))
            print(codigoHTML.finalHTML)

    else:
        print(codigoHTML.cabeceraHTML.format("Registro fallado",
                                             '<meta http-equiv="Refresh" content="3; URL=login.html"/>', "Usuario o Contraseña incorrectos. Intenta de nuevo."))
        print(codigoHTML.finalHTML)


except:
    print(codigoHTML.cabeceraHTML.format(
        "", '<meta http-equiv="Refresh" content="0; URL=../error.html"/>', ""))
    print(codigoHTML.finalHTML)
