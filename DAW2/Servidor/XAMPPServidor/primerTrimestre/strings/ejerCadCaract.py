#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import cgi
print("Content-Type: text/text\n")

args = cgi.parse()

texto = args['cadena'][0]
busca = args['busca'][0]
letra = args['letra'][0]

print("Ejercicios de cadenas\n")
print("=====================\n")
print("Texto recibido:", texto, "\n")
print("Palabra a buscar:", busca, "\n")
print("Letra a buscar:", letra, "\n")

cont = 0

for temp in texto:
    if temp != ' ':
        cont = cont + 1
print("\n1.Contar las letras de una frase: ",cont)

if busca in texto:
    print("\n2. Buscar una palabra dentro de una frase: Palabra encontrada.")
else:
    print("\n2. Buscar una palabra dentro de una frase: Palabra no encontrada.")

cont = 0

for temp in texto:
    if letra == temp:
        cont = cont + 1
print("\n3. Contar las veces que aparece una letra dentro de una frase:", cont)

conta = 0
conte = 0
conti = 0
conto = 0
contu = 0

for temp in texto:
    if 'a' == temp or 'A' == temp:
        conta = conta + 1
    if 'e' == temp or 'E' == temp:
        conte = conte + 1
    if 'i' == temp or 'I' == temp:
        conti = conti + 1
    if 'o' == temp or 'O' == temp:
        conto = conto + 1
    if 'u' == temp or 'U' == temp:
        contu = contu + 1
print("\n4. Contar todas las veces que aparecen las vocales en una frase por separado, número de a, número de e, etc...")
print("El texto contiene la letra 'A-a' ", conta, "veces")
print("El texto contiene la letra 'E-e' ", conte, "veces")
print("El texto contiene la letra 'I-i' ", conti, "veces")
print("El texto contiene la letra 'O-o' ", conto, "veces")
print("El texto contiene la letra 'U-u' ", contu, "veces")

print("\n5. Dividir una frase en palabras.")
for temp in texto.split():
    print(temp)

print("\n6. Dar la vuelta a las palabras de una frase.")
temp = ''
salida = ''

for index in texto:
    if index != ' ':
        temp = index + temp
    else:
        salida = salida + ' ' + temp
        temp = ''
salida = salida + ' ' + temp
print(salida)