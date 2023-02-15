#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import cgi
import mysql.connector

args = cgi.parse()

# socio = args['socio'][0]
# titulo = args['titulo'][0]
# autor = args['autor'][0]

mydb = mysql.connector.connect(
    host='localhost',
    user='biblioteca',
    password='biblioteca',
    database='biblioteca'
)

mycursor = mydb.cursor()

mycursor.execute("SELECT nombre FROM socios")
myresult = mycursor.fetchall()

print("Content-Type: text/plain\n")
