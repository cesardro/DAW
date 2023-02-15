#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

print("Content-Type: text/text\n")

persona = {
    "nombre": "Juan",
    "apellidos": "Lopez Lopez",
    "edad": 33,
    "pareja": True,
    "deportes": ["surf", "skate", "atletismo"]
}

print(persona)
print(type(persona))

print("La edad de", persona["nombre"], "es", persona["edad"])

persona["nombre"] = "Jose"
persona["edad"] = 25

print("La edad de", persona["nombre"], "es", persona["edad"])

print(persona["deportes"][1])

claves = persona.keys()

print(claves)

persona["altura"] = 180

print(claves)

valores = persona.values()

print("VALORES: ", valores)

listadeTuplas = persona.items()

print(listadeTuplas)

for itm in listadeTuplas:
    print("=============", itm[0], itm[1])

persona["peso"] = 80

for itm in listadeTuplas:
    print(itm[0], itm[1])

if "fechaNac" in persona:
    print(persona["fechaNac"])
else:
    print("No tiene fecha de nacimiento.")
