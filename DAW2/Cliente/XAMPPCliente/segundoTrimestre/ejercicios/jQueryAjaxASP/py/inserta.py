#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import cgi
import mysql.connector
import json


form = cgi.FieldStorage()

el = form['EquipoLocal'].value
ev = form['EquipoVisitante'].value

gl = int(form['GolesLocal'].value)
gv = int(form['GolesVisitante'].value)

# Conectar a BD
mydb = mysql.connector.connect(
    host="localhost",
    user="campeonatoFutbol",
    password="campeonatoFutbol",
    database="campeonatoFutbol"
)

# Insertar en BD
mycursor = mydb.cursor()
sql = 'INSERT INTO resultados(EquipoLocal, EquipoVisitante, GolesLocal, GolesVisitante) VALUES (%s, %s, %s, %s)'
val = (el, ev, gl, gv)
mycursor.execute(sql, val)
mydb.commit()

sql = 'SELECT @@identity'
mycursor.execute(sql)
ultimoId = json.dumps(mycursor.fetchall())

print("Content-type:text/plain\n")
print(ultimoId)
