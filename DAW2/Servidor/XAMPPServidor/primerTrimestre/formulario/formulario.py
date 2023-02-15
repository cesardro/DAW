#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

print("Content-Type: text/plain\n")

import cgi

args = cgi.parse()

print(args['nombre'][0]) #Imprime el dato que devuelve del formulario.
print(args['edad'][0])

print(type(args)) #Imprime el tipo de dato que devuelve del formulario.
print(type(args['edad'])) #Listado, "un array".
print(type(args['edad'][0])) #Posición 0, un string.

edad = int(args['edad'][0]) 

print(edad) #Imprime la edad convertida de sting a integer.
print(type(edad)) #Integer.