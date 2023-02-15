#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

from datetime import date, timedelta
import datetime
import cgi

datosForm = cgi.FieldStorage()

fecha = datosForm["fecha"].value if "fecha" in datosForm else False

print("Content-Type: text/plain\n")

if fecha:
    fecha = fecha.split("-")
    dFecha = datetime.datetime(int(fecha[0]), 12, 31)
    if int(dFecha.strftime("%j")) == 366:
        print("Es bisiesto")
    else:
        print("No es bisiesto")
else:
    print("Error")
# =========================================================================
fecha = datosForm["fecha"].value if "fecha" in datosForm else datetime.datetime.now()
listaFecha = fecha.split("-")
f = datetime.datetime(int(listaFecha[0]), int(
    listaFecha[1]), int(listaFecha[2]))

print(f)
# =========================================================================
dt = date.today() - timedelta(5)
dd = date.today() + timedelta(5)
print('Dia de hoy:', date.today())
print('5 dias restados:', dt)
print('5 dias sumados:', dd)

# =========================================================================
ayer = date.today() - timedelta(1)
mañana = date.today() + timedelta(1)
print('Ayer : ', ayer)
print('Hoy : ', date.today())
print('Mañana : ', mañana)

# =========================================================================
for n in range(0, 5):
    print(date.today()+timedelta(n))
# =========================================================================
print("Incremento 5 segundos:")
print(datetime.datetime.now().time())
dm = datetime.datetime.now()+timedelta(seconds=5)
print(dm.time())
# =========================================================================
print("AHORA: ", datetime.datetime.now())


# timedelta  days=50,
# seconds=27,
# microseconds=10,
# milliseconds=29000,
# minutes=5,
# hours=8,
# weeks=2

# %a	Weekday, short version	Wed
# %A	Weekday, full version	Wednesday
# %w	Weekday as a number 0-6, 0 is Sunday	3
# %d	Day of month 01-31	31
# %b	Month name, short version	Dec
# %B	Month name, full version	December
# %m	Month as a number 01-12	12
# %y	Year, short version, without century	18
# %Y	Year, full version	2018
# %H	Hour 00-23	17
# %I	Hour 00-12	05
# %p	AM/PM	PM
# %M	Minute 00-59	41
# %S	Second 00-59	08
# %f	Microsecond 000000-999999	548513
# %z	UTC offset	+0100
# %Z	Timezone	CST
# %j	Day number of year 001-366	365
# %U	Week number of year, Sunday as the first day of week, 00-53	52
# %W	Week number of year, Monday as the first day of week, 00-53	52
# %c	Local version of date and time	Mon Dec 31 17:41:00 2018
# %C	Century	20
# %x	Local version of date	12/31/18
# %X	Local version of time	17:41:00
# % %	A % character	%
# %G	ISO 8601 year	2018
# %u	ISO 8601 weekday (1-7)	1
# %V	ISO 8601 weeknumber (01-53)	01
