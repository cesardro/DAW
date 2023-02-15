#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import cgi
from genericpath import exists
import codigoHTML
import hashlib
import mysql.connector

mydb = mysql.connector.connect(
    host='localhost',
    user='logRegConBD',
    password='logRegConBD',
    database='logRegConBD'
)

print("Content-Type: text/html\n")

args = cgi.parse()

proceder = False

mycursor = mydb.cursor()

try:
    name = args['name'][0]
    # Encriptado de contraseñas
    pswd = hashlib.sha512(str.encode(args["pswd"][0]))
    pswd = (pswd.hexdigest())
    email = args['email'][0]

    mycursor.execute("SELECT * FROM logRegConBD where name='" +
                     name + "' OR email='"+email+"'")

    myresult = mycursor.fetchall()

    for x in myresult:
        if (x[1] == name or x[3] == email):
            proceder = True

    if proceder:
        print(codigoHTML.cabeceraHTML.format("Registro fallado",
                                             '<meta http-equiv="Refresh" content="2; URL=../aplicacion.html"/>', "Usuario o correo duplicado. Redirigiendo"))
        print(codigoHTML.finalHTML)
    else:
        sql = "INSERT INTO logRegConBD (name, pswd, email, admin) VALUES (%s, %s, %s, %s)"
        val = (name, pswd, email, 0)
        mycursor.execute(sql, val)
        mydb.commit()

        print(codigoHTML.cabeceraHTML.format("Registro completado",
                                             '<meta http-equiv="Refresh" content="2; URL=../aplicacion.html"/>', "Registro completado. Redirigiendo"))
        print(codigoHTML.finalHTML)

except:
    print(codigoHTML.cabeceraHTML.format("",
          '<meta http-equiv="Refresh" content="0; URL=../error.html"/>', ""))
    print(codigoHTML.finalHTML)
