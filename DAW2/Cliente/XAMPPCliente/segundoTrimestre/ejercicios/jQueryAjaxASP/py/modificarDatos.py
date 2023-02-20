#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import cgi
import mysql.connector

form = cgi.FieldStorage()

el = form['EquipoLocal'].value
ev = form['EquipoVisitante'].value

gl = int(form['GolesLocal'].value)
gv = int(form['GolesVisitante'].value)

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
sql = "UPDATE resultados SET EquipoLocal = %s, EquipoVisitante = %s, GolesLocal = %s, GolesVisitante = %s WHERE ID = %s;"
val = (el, ev, gl, gv, id)
mycursor.execute(sql, val)
mydb.commit()

print("Content-type:text/plain\n")
print("Inserción correcta")
