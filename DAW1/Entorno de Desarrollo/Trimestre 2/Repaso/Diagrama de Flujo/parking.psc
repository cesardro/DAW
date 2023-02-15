Algoritmo parking
	Escribir "Introducir hora entrada: ";
	Leer hEntrada;
	Escribir "Introducir hora salida: ";
	Leer hSalida;
	horas = hSalida - hEntrada;
	total = 1.20 + ((horas-1)*0.85);
	Escribir "El total es: " total;
FinAlgoritmo
