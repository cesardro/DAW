#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

print("Content-Type: text/plain\n")

import cgi

args = cgi.parse()

num = int(args['numero'][0])

if num >= 1 and num <= 10:
    for n in range(1,11):
        print(num," x ", n, " = ", num*n)
else:
    print("Ingresa un número entre 1 y 10")


