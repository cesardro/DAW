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

for x in range(1, 20):
    print("<div id='contenedor", x, "'>")
    texto = '<img src="coche/coche' + \
        str(x) + '.png" alt="imagen de coche' + str(x) + '">'
    print(texto)
    print("</div>")

print("""
</body>
</html>
""")
