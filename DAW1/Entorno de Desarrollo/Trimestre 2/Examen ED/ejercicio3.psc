Algoritmo ejercicio3
	Definir totalEnTodoElDia Como Real;
	totalEnTodoElDia = 0;
	Definir totalCompra Como Real;
	totalCompra = 0;
	clienteAnterior = "";
	Escribir "Ingrese comando: ";
	Leer letra;
	Mientras letra = "A" Hacer
		Escribir "Ingrese segundo comando: ";
		Leer letra;
		Mientras letra = "U" o letra = "P" Hacer
			Si letra = "U" Entonces
				Escribir "Ingresar cantidad: ";
				Leer cantidad;
				Escribir "Ingresar precio: ";
				Leer precio;
				totalCompra = totalCompra + (precio*cantidad);
			Fin Si
			Si letra = "P" Entonces
				Escribir "Ingresar peso total: ";
				Leer pesoTotal;
				Escribir "Ingresar precio por KG: ";
				Leer precioKG;
				totalCompra = totalCompra + (pesoTotal*precioKG);
			Fin Si
			Escribir "Ingresar segundo comando: ";
			Leer letra;
		Fin Mientras
		Escribir "El importe total es: " totalCompra;
		totalEnTodoElDia = totalEnTodoElDia + totalCompra;
		totalCompra = 0;
	Fin Mientras
	Escribir "Dinero hecho en un día: " totalEnTodoElDia;
FinAlgoritmo