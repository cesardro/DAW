#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import cgi
import mysql.connector
import json

mydb = mysql.connector.connect(
    host='localhost',
    user='ventaCamiones',
    password='ventaCamiones',
    database='ventaCamiones',
)

mycursor = mydb.cursor()

form = cgi.FieldStorage()
marca = form['marca'].value
modelo = form['modelo'].value
precio = form['precio'].value
desc = form['desc'].value

resultado = True

sql = "INSERT INTO camiones (marca, modelo, precio,  descripcion, fechaCreacion) VALUES (%s, %s, %s, %s, now())"
val = (marca, modelo, precio, desc)

mycursor.execute(sql, val)
mydb.commit()

print("Content-Type: text/plain\n")
print(json.dumps(resultado))
