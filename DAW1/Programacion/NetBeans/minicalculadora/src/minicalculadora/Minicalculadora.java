package minicalculadora;

import java.util.Scanner;

public class Minicalculadora 
{
    public static void main(String[] args) 
    {
        int numero1, numero2;
        
        Scanner preg = new Scanner (System.in);
        
        System.out.print("Primer numero:");
        numero1 = preg.nextInt();
        
        System.out.print("Segundo numero:");
        numero2 = preg.nextInt();
        
        System.out.println("Resultados:");      
        System.out.println("Suma:"+(numero1+numero2));
        System.out.println("Resta:"+(numero1-numero2));
        System.out.println("Multiplicacion:"+(numero1*numero2));
        System.out.println("Division:"+(numero1/numero2));
    }
}
