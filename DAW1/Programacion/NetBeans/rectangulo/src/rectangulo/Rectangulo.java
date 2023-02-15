package rectangulo;

import java.util.Scanner;

public class Rectangulo {
    public static void main(String[] args) 
    {
        double base, altura;
        
        Scanner preg = new Scanner(System.in);
        
        System.out.print("Introducir base: ");
        base = preg.nextDouble();
        
        System.out.print("Introducir altura: ");
        altura = preg.nextDouble();
        
        System.out.println("El area del rectangulo es: "+(base*altura));
        System.out.println("El perimetro del rectangulo es: "+(2*(base+altura)));
    }
}
