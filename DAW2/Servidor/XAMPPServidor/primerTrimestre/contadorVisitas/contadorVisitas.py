#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import cgi
import CodigoHTML
print("Content-Type: text/html\n")


args = cgi.parse()  # Diccionario

contadorLista = args.get("contador", [0])
contador = int(contadorLista[0])

# Incremento del contador
contador = contador + 1

# Inicio del código HTML
print(CodigoHTML.cabeceraHTML.format(
    "Contador de visitas", "Contador de visitas"))

#print('<a href="contadorVisitas.py?contador=' + str(contador) + '">Llevas: '+str(contador)+'</a><br>')
print('<p>Llevas '+str(contador)+' visitas</p>')

print('<form action="contadorVisitas.py" method="post">')
print('<input type="text" name="nombre">')
print('<input type="hidden" name="contador" value="'+str(contador)+'">')
print('<button type="submit">Enviar</button>')
print('</form>')

# Fin del código HTML
print(CodigoHTML.finalHTML)
