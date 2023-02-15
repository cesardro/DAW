#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import mysql.connector
from configuracion import configBD


def regTiempos(operacion, parametros, usuarioId):
    mydb = mysql.connector.connect(
        host=configBD["host"],
        user=configBD["user"],
        password=configBD["password"],
        database=configBD["database"]
    )

    mycursor = mydb.cursor()

    sql = "INSERT INTO regOperaciones (usuarioid, operacion, parametros, tmpAccion) VALUES (%s,%s,%s, now())"
    val = (usuarioId, operacion, parametros)
    mycursor.execute(sql, val)
    mydb.commit()
