#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import mysql.connector
import json

mydb = mysql.connector.connect(
    host="localhost",
    user="campeonatoFutbol",
    password="campeonatoFutbol",
    database="campeonatoFutbol"
)

mycursor = mydb.cursor()

mycursor.execute("SELECT * FROM resultados")
myresult = mycursor.fetchall()

datos = []

for x in myresult:
    datos += {
        "EquipoLocal": x[1],
        "EquipoVisitante": x[2],
        "GolesLocal": x[3],
        "GolesVisitante": x[4],
        "IDTabla": x[0]
    },

salida = json.dumps(datos)

print("Content-type:text/plain\n")
print(salida)
