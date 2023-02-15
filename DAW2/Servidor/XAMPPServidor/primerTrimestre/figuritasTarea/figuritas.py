#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import cgi
print("Content-Type: text/plain\n")

args = cgi.parse()
nfilas = int(args["nfilas"][0])
figura = int(args["figura"][0])

def astericos(n):
    print("Asteriscos\n")
    for i in range(n):
        print(' '*(n-i-1) + '* '*(i+1))
    for i in range(n):
        print(' '*(i+1) + '* '*(n-i-1))

def numeros(n):
    print("Números\n")
    for i in range(n):
        print(' '*(n-i-1) + (str(i+1)+' ')*(i+1))
    for i in range(n):
        print(' '*(i+1) + (str((n-i-2)+1)+' ')*(n-i-1))

def abc(n):
    print("ABC\n")
    listaABC = ["A","B","C","D","E","F","G","H","I","J","K","L","M","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"]

    for i in range(n):
        print(' '*(n-i-1) + (listaABC[i]+' ')*(i+1))
    for i in range(n):
        print(' '*(i+1) + (listaABC[n-i-2]+' ')*(n-i-1))

    #chr saca codigo ASCII, por lo que no seria necesario un array con el abecedario.
    # for i in range(n):
    #     print(' '*(n-i-1) + (chr(65+i)+' ')*(i+1))
    # for i in range(n):
    #     print(' '*(i+1) + (chr(65+n-i-2)+' ')*(n-i-1))

if(figura == 1):
    astericos(nfilas)
elif(figura == 2):
    numeros(nfilas)
elif(figura == 3):
    abc(nfilas)
else:
    print("Opción no contemplada")