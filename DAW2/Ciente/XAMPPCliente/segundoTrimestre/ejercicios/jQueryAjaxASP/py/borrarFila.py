#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import cgi
import mysql.connector

form = cgi.FieldStorage()

id = int(form['ID'].value)

# Conectar a BD
mydb = mysql.connector.connect(
    host="localhost",
    user="campeonatoFutbol",
    password="campeonatoFutbol",
    database="campeonatoFutbol"
)

# Insertar en BD
mycursor = mydb.cursor()
sql = "DELETE FROM resultados WHERE ID = %s"
val = (id,)
mycursor.execute(sql, val)
mydb.commit()

print("Content-type:text/plain\n")
print("Inserción correcta")
