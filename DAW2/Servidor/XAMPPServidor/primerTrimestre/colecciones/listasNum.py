#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

print("Content-Type: text/plain\n")

listaNumeros = [1, 6, 4, 5, 1, 8, 3, 4, 5, 9, 7, 2, 1]

listaMayores5 = [n for n in listaNumeros if n > 5]

listaMenores5 = [n for n in listaNumeros if n < 5]

print("La lista de mayores de 5 son: ,"listaMayores5,"\n")
print("La lista de mayores de 5 son: ,"listaMenores5,"\n")

thislist = ["apple", "banana", "cherry"]

print("Hay", len(thislist),"elementos.\n")

print("Tiene: ")

[print(x) for x in thislist]
print()

print("Son de tipo: ")
[print(type(x)) for x in thislist]
