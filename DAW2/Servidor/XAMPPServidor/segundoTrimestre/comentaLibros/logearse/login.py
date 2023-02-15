#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

from configuracion import configBD
from genericpath import exists
from http import cookies
import cgi
import datetime
import codigoHTML
import hashlib
import mysql.connector
from regOperaciones import regTiempos

args = cgi.parse()

proceder = False
soyAdmin = False

mydb = mysql.connector.connect(
    host=configBD["host"],
    user=configBD["user"],
    password=configBD["password"],
    database=configBD["database"]
)

mycursor = mydb.cursor()

name = args["name"][0]
# Encriptado de contraseñas
pswd = hashlib.sha512(str.encode(args["pswd"][0]))
pswd = (pswd.hexdigest())

try:

    mycursor.execute("SELECT * FROM usuarios where usuario='" + name + "'")

    myresult = mycursor.fetchall()

    usuId = 0
    for x in myresult:
        if (name == x[1] and pswd == x[2]):
            proceder = True
            usuId = x[0]
            parametros = "nombre="+name+"&password="+pswd
        if (x[4] == 1):
            soyAdmin = True

    if proceder:
        coki = cookies.SimpleCookie()
        coki["SID"] = name
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
                "Logeado", '<meta http-equiv="Refresh" content="3; URL=interfaz.py"/>', "Logeado exitosamente. Redirigiendo a pagina."))
            print(codigoHTML.finalHTML)

        regTiempos("login.py", parametros, usuId)

    else:
        print(codigoHTML.cabeceraHTML.format("Registro fallado",
                                             '<meta http-equiv="Refresh" content="3; URL=login.html"/>', "Usuario o Contraseña incorrectos. Intenta de nuevo."))
        print(codigoHTML.finalHTML)


except:
    print(codigoHTML.cabeceraHTML.format(
        "", '<meta http-equiv="Refresh" content="0; URL=../error.html"/>', ""))
    print(codigoHTML.finalHTML)
