Algoritmo horasParking
	Escribir 'Hora de entrada: ';
	Leer hE;
	Escribir 'Hora de salida: ';
	Leer hS;
	horas <- hS - hE;
	total <- 1.20 + (horas-1)*0.85;
	Escribir total;
FinAlgoritmo
