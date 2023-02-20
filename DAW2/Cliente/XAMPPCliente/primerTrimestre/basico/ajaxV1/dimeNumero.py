#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import cgi

args = cgi.parse()

n = int(args['num'][0])

print("Content-Type: text/text\n")

print("Hola...",n*2)