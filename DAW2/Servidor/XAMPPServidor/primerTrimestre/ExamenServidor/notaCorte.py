#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import cgi

nombres = open("nombres.dat", "rt")
notas = open("notas.dat", "rt")

args = cgi.parse()
corte = args["corte"][0]

datosEnNombres = nombres.read()
nombres.close()

datosEnNotas = notas.read()
notas.close()

nombres = datosEnNombres.split()
notas = datosEnNotas.split()

f = open("salida.dat", "w")
for x in range(len(notas)):
    if notas[x] >= corte:
        f.write(nombres[x] + " " + notas[x] + "\n")
f.close()

print("Content-Type: text/html\n")
print("""
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 1</title>
</head>

<body>
    <p>Filtro realizado...</p>
</body>
</html>
""")
