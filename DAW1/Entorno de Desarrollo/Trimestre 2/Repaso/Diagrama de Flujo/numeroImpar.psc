Algoritmo numeroPar
	Escribir 'Ingresar n�mero: ';
	Leer n;
	Para contador<-0 Hasta n Con Paso 1 Hacer
		m <- contador%2;
		Si m = 1 Entonces
			Escribir 'El n�mero ' contador ' es impar.';
		Fin Si
	Fin Para
FinAlgoritmo
