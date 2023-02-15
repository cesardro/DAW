#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

from configuracion import configBD
import cgi
import codigoHTML
import mysql.connector
from regOperaciones import regTiempos

args = cgi.parse()
idUser = args["idUsuario"][0]

mydb = mysql.connector.connect(
    host=configBD["host"],
    user=configBD["user"],
    password=configBD["password"],
    database=configBD["database"]
)

mycursor = mydb.cursor()

mycursor.execute("SELECT usuario FROM usuarios WHERE id="+idUser)
myresult = mycursor.fetchall()

regTiempos("borrar.py", "nombreBorrado=" +
           str(myresult[0][0])+"&idBorrado="+idUser, 1)

mycursor.execute("DELETE FROM usuarios WHERE id="+idUser)
mydb.commit()


print("Content-Type: text/html\n")

print(codigoHTML.cabeceraHTML.format("Borrado con exito",
      '<meta http-equiv="Refresh" content="2; URL=soyAdmin.py"/>', "Borrado con exito. Redirigiendo", "", ""))
print(codigoHTML.finalHTML)
