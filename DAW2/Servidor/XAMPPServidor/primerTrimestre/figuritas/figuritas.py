#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import cgi
print("Content-Type: text/plain\n")

args = cgi.parse()
nfilas = int(args["nfilas"][0])
figura = int(args["figura"][0])

#Información extraida directamente del link, agregando algo como por ejemplo: ?nfilas=5&figura=6 al final.

#Funcion cuadrado
def cuadrado(nf):
    print("Vamos a dibujar un cuadrado de ", args["nfilas"][0], "asteriscos")
    linea = ""

    for i in range(nfilas):
        for j in range(nfilas):
            linea += "*"
        print(linea)
        linea = ""
#Fin de la función cuadrado

#Funcion triangulo normal
def trianguloN(nf):
    print("Vamos a dibujar un triangulo de ", args["nfilas"][0], "asteriscos")

    nfilas = int(args["nfilas"][0])
    linea = ""

    for i in range(nfilas):
        for j in range(i+1):
            linea += "*"
        print(linea)
        linea = ""
#Fin de la función triangulo normal

#Funcion triangulo normal vuelta
def trianguloNV(nf):    
    print("Vamos a dibujar un triangulo girado de ",
        nfilas, "asteriscos en su punto mas largo")
    linea = ""

    for i in range(nfilas, 0, -1):
        for j in range(i):
            linea += "*"
        print(linea)
        linea = ""
#Fin de la función triangulo normal vuelta

#Funcion triangulo normal reves
def trianguloNR(nf):
    print("Vamos a dibujar un triangulo al reves de ",
        nfilas, "asteriscos en su punto mas largo")
    linea = ""

    for i in range(nfilas):
        for j in range(nfilas-i+1):
            linea += " "
        for j in range(i+1):
            linea += "*"
        print(linea)
        linea = ""
#Fin de la función triangulo normal reves

#Funcion triangulo normal reves vuelta
def trianguloNRV(nf):
    print("Vamos a dibujar un triangulo normal de vuelta del reves de ",
        nfilas, "asteriscos")
    linea = ""

    for i in range(nfilas, 0, -1):
        for j in range(nfilas - i):
            linea += " "
        for j in range(i):
            linea += "*"  
        print(linea)
        linea = ""  
#Fin de la función triangulo normal reves vuelta

if(figura == 1):
    cuadrado(nfilas)
elif(figura == 2):
    trianguloN(nfilas)
elif(figura == 3):
    trianguloNV(nfilas)
elif(figura == 4):
    trianguloNR(nfilas)
elif(figura == 5):
    trianguloNRV(nfilas)
else:
    print("Opción no contemplada")