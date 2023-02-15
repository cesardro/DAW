#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import cgi
import codigoHTML
import mysql.connector

estasDentro = False

args = cgi.parse()
idUser = args["idUsuario"][0]

mydb = mysql.connector.connect(
    host='localhost',
    user='logRegConBD',
    password='logRegConBD',
    database='logRegConBD'
)

mycursor = mydb.cursor()
mycursor.execute("DELETE FROM logRegConBD WHERE id="+idUser)
mydb.commit()

print("Content-Type: text/html\n")

print(codigoHTML.cabeceraHTML.format("Borrado con exito",
      '<meta http-equiv="Refresh" content="2; URL=soyAdmin.py"/>', "Borrado con exito. Redirigiendo", "", ""))
print(codigoHTML.finalHTML)
