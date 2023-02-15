#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import random
import cgi
print("Content-Type: text/plain\n")

args = cgi.parse()

# Convertimos el get en string y lo ponemos lowercase.
ppt = str.lower(args['ppt'][0])

#Creamos un random de 1 a 3.
#Siendo 1 = Piedra, 2 = Papel y 3 = Tijera
ran = random.randint(1, 3)

if ppt == 'papel' or ppt == 'tijera' or ppt == 'piedra':
    #Piedra
    if ran == 1:
        print('La máquina tiene: piedra')
        if ppt == 'piedra':
            print('Empate de piedra.')
        elif ppt == 'papel':
            print('Gana jugador con papel!')
        elif ppt == 'tijera':
            print('Gana máquina con piedra!')
    #Papel
    elif ran == 2:
        print('La máquina tiene: papel')
        if ppt == 'piedra':
            print('Gana máquina con papel!')
        elif ppt == 'papel':
            print('Empate de papel.')
        elif ppt == 'tijera':
            print('Gana jugador con tijera!')
    #Tijera
    elif ran == 3:
        print('La máquina tiene: tijera')
        if ppt == 'piedra':
            print('Gana jugador con piedra!')
        elif ppt == 'papel':
            print('Gana máquina con tijera!')
        elif ppt == 'tijera':
            print('Empate de tijera!')
else:
    print('Palabra no válida, intenta de nuevo ingresando la palabra adecuada.')