#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

print("Content-Type: text/html\n")

print("<!DOCTYPE html>")
print("<html>")
print("<head>")
print("</head>")
print("<body>")
print("\t<h1>Hola Mundo</h1>")
if 5 > 2:
    print("Five is greater than two!<br>")
    print("Hola<br>")
    if 3 < 2:
        print("Three is greater than two!<br>")
#Esto es un comentario
a, b = 5, 10
c = a*b
print("<h3>",c,"</h3>")

x = "awesome"
def myFunc():
    x = "fantastic"
    print("Python is ", x)

myFunc()

print("<br>Python is ", x)

for y in range(11):
    print("<br>", y, " x 7 = ")

print("</body>")
print("</html>")