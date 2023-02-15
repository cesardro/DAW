#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import cgi

print("Content-Type: text/html\n")

args = cgi.parse()

texto = args["cadena"][0]

inver = "";

for letra in texto:
    inver = letra + inver;
print(inver);