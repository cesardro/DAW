#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

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
""")

preciosProductosID = {
    "CA132": 99.2,
    "CB231": 55.7,
    "CA332": 101.0,
    "CD563": 65.2,
    "CB838": 48.1
}

print("<table>")
print("<tr >")
print("<td>Identificador</td>")
print("<td>Precio</td>")
print("</tr>")

listadeTuplas = preciosProductosID.items()
cont = 0
for x in listadeTuplas:
    print("<tr >")
    print("<td>", x[0], "</td>")
    print("<td>", x[1], "</td>")
    print("</tr>")
    cont = cont + x[1]

print("<tr >")
print("<td>Total:</td>")
print("<td>", cont, "</td>")
print("</tr>")

print("</table>")

print("""
</body>
</html>
""")
