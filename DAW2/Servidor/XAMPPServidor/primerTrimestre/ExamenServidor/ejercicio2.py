#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

def concatenaVocales(letras):
    salida = ""
    if len(letras) <= 5:
        for x in range(0, len(letras)):
            if letras[x] == 'A' or letras[x] == 'E' or letras[x] == 'I' or letras[x] == 'O' or letras[x] == 'U':
                salida += letras[x]
            else:
                return ("Error")
    else:
        return ("Error")

    return (salida)


listaLetras = ['A', 'E', '1', 'O', 'O']

print("Content-Type: text/plain\n")

print(concatenaVocales(listaLetras))
