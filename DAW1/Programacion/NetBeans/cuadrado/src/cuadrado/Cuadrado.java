package cuadrado;

import java.util.Scanner;

public class Cuadrado {
    public static void main(String[] args) 
    {
        double lado;
        
        Scanner preg = new Scanner(System.in);
        System.out.print("Lado del cuadrado: ");
        lado = preg.nextDouble();
        
        System.out.println("El area del cuadrado es: "+(lado*lado));    
        System.out.println("El perimetro del cuadrado es: "+(lado+lado+lado+lado));    
    }
}
