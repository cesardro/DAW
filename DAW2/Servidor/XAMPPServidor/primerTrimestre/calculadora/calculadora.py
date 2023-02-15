#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import cgi

print("Content-Type: text/plain\n")

args = cgi.parse()

num1 = int(args['num1'][0])
num2 = int(args['num2'][0])
rad = int(args['oper'][0])

if rad == 1:
    print('Suma: ', (num1+num2))
elif rad == 2:
    print('Resta: ', (num1-num2))
elif rad == 3:
    print('Multiplicación: ', (num1*num2))
elif rad == 4:
    print('Multiplicación: ', (num1/num2))
