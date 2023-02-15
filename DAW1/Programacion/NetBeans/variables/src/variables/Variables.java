package variables;

import java.util.Scanner;

public class Variables 
{
    public static void main(String[] args) 
    {
        int edad;
        
        Scanner preg = new Scanner (System.in);
        
        System.out.println("Cual es tu edad?");
        
        edad = preg.nextInt();
        
        System.out.println("Tu edad es:"+edad);
    }
}
