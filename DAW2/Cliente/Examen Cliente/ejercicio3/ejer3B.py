#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import cgi
import json

form = cgi.FieldStorage()
p = int(form['parr'].value)

resultado = "Sin texto"

if p == 1:
    resultado = json.dumps(''' Con diez cañones por banda,<br>
                                viento en popa, a toda vela,<br>
                                no corta el mar, sino vuela,<br>
                                un velero bergantín:<br>
                                bajel pirata que llaman,<br>
                                por su bravura, el Temido,<br>
                                en todo mar conocido<br>
                                del uno al otro confín.<br>''')
elif p == 2:
    resultado = json.dumps(''' La luna en el mar riela,<br>
                               en la lona gime el viento,<br>
                               y alza en blando movimiento<br>
                               olas de plata y azul;<br>
                               y va el capitán pirata,<br>
                               cantando alegre en la popa,<br>
                               Asia a un lado, al otro Europa,<br>
                               y allá a su frente Estambul:<br>''')
elif p == 3:
    resultado = json.dumps(''' Navega, velero mío,<br>
                               sin temor,<br>
                               que ni enemigo navío,<br>
                               ni tormenta, ni bonanza<br>
                               tu rumbo a torcer alcanza,<br>
                               ni a sujetar tu valor.<br>
                               <br>
                               Veinte presas<br>
                               hemos hecho<br>
                               a despecho<br>
                               del inglés,<br>
                               y han rendido<br>
                               cien naciones<br>
                               sus pendones<br>
                               a mis pies."<br>''')
print("Content-Type: text/plain\n")
print(resultado)
