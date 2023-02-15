Proceso MayorYMenorDe4Numeros
    mayor <- 0;
    menor <- 0;
    Para i<-1 Hasta 4 Con Paso 1 Hacer
        Escribir "Numero: ", i;
        Escribir Sin Saltar "Ingresa el valor de un numero:";
        Leer n;
        Si i = 1 O mayor<n Entonces
            mayor <- n;
        FinSi
        Si i = 1 O menor>n Entonces
            menor <- n;
        FinSi
        Escribir "";
    FinPara
    Escribir "Valor de mayor: ", mayor;
    Escribir "Valor de menor: ", menor;
FinProceso