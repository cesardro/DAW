Algoritmo promedioNotas
	cont = 0;
	definir suma Como Real;
	suma = 0;
	definir promedio Como Real;
	promedio = 0;
	Escribir "Escribe notas, si es 0 el programa termina: ";
	Escribir Sin Saltar "Nota: ";
	Leer nota;
	Mientras nota <> 0 Hacer
		cont = cont + 1;
		suma = suma + nota;
		promedio = suma / cont;
		Escribir "El promedio de las notas es: " promedio;
		Escribir Sin Saltar "Nota: ";
		Leer nota;
	FinMientras
FinAlgoritmo
