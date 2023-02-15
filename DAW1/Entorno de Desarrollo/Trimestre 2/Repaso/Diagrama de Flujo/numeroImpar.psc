Algoritmo numeroPar
	Escribir 'Ingresar número: ';
	Leer n;
	Para contador<-0 Hasta n Con Paso 1 Hacer
		m <- contador%2;
		Si m = 1 Entonces
			Escribir 'El número ' contador ' es impar.';
		Fin Si
	Fin Para
FinAlgoritmo
