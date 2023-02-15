#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import mysql.connector

mydb = mysql.connector.connect(
    host='localhost',
    user='generico',
    password='generico',
    database='generico'
)

cantRegistro = 5

mycursor = mydb.cursor()

mycursor.execute("DELETE FROM tabla")

sql = 'INSERT INTO tabla (columna1, columna2, columna3) VALUES (%s, %s, %s)'


for i in range(cantRegistro):
    val = ('Valor 1'+str(i), 'Valor 2'+str(i), str(i))
    mycursor.execute(sql, val)

mydb.commit()

print("Content-Type: text/plain\n")

mycursor.execute("SELECT * FROM tabla")

myresult = mycursor.fetchall()

print(type(myresult))
print(myresult)

for x in myresult:
    print(x[0], " - ", x[1], " - ", x[2], " - ", x[3])

mycursor.execute("SELECT * FROM tabla")

myresult = mycursor.fetchone()

print(type(myresult))

print(myresult)
print(myresult[1])
