#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import os, datetime, codigoHTML
from http import cookies

todasCokis={} #diccionario vacio
if 'HTTP_COOKIE' in os.environ:
    listaCoki = os.environ['HTTP_COOKIE'] #"SID=ASDFasdf344"
    listaCoki = listaCoki.split('; ') #["SID=ASDFasdf344"]

    for elemCoki in listaCoki:
        (nombre, valor) = elemCoki.split('=')
        todasCokis[nombre]=valor

      #todasCokis["SID"]="ASDFasdf344"


if 'SID' in todasCokis:
    coki = cookies.SimpleCookie()
    #esta parte solo se ejecuta la primera vez que accede el usuario
    coki["SID"]=todasCokis["SID"]
    expires = datetime.datetime.utcnow() + datetime.timedelta(days=-1) # enviar cookie caducada
    coki['SID']['expires'] = expires.strftime("%a, %d %b %Y %H:%M:%S GMT")
    print(coki)

print("Content-Type: text/html\n")    

print(codigoHTML.cabeceraHTML.format("Cookie Borrada",'<meta http-equiv="Refresh" content="2; URL=../aplicacion.html"/>', "Borrando Cookie..."))
print(codigoHTML.finalHTML)