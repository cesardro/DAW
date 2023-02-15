#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import cgi
args = cgi.parse()

print("Content-Type: text/text\n")


def sacoPorPantalla(fruta):
    print("Esto es: ", fruta)


thislist = ["manzana", "platano", "fresa"]
newlist = [x for x in thislist if "a" in x]

[sacoPorPantalla(x) for x in thislist]

listaNumeros = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

listaMayores5 = [n for n in listaNumeros if n > 5]
print(listaMayores5)

listaMenores5 = [n for n in listaNumeros if n < 5]
print(listaMenores5)
