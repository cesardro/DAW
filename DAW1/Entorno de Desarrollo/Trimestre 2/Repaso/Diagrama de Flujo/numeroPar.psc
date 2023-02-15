Algoritmo numeroPar
	Escribir 'Ingresar número: ';
	Leer n;
	total <- 0;
	Para cont<-0 Hasta n Con Paso 1 Hacer
		m <- cont%2;
		Si m = 0 Entonces
			total = total + cont;
		Fin Si
	Fin Para
	Escribir 'La suma total de pares es: ' total;
FinAlgoritmo