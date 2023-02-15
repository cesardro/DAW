package triangulo;

import java.util.Scanner;

public class Triangulo {
    public static void main(String[] args) 
    {
        double lado, res;
        double altura = 1.732;
        
        Scanner preg = new Scanner(System.in);
        System.out.print("Introducir lado: ");
        lado = preg.nextDouble();
        
        res = (altura*lado)/2;
        System.out.println("El area del triangulo es: "+ res);
        
        res = 3*lado;
        System.out.println("El perimetro del triangulo es: "+ res);
    }
}
