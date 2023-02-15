package figurasgeomherencia;

import figurasBase.Cuadrado;
import figurasBase.Rectangulo;
import figurasBase.Circulo;

public class FigurasGeomHerencia {
    public static void main(String[] args) {
        
    //  Se crea el objeto cir1 de la clase Circulo
    //con radio 5.0
    Circulo cir1 = new Circulo(5.0);
     
    //  Se crea el objeto cir2 de la clase Circulo
    //con radio 10.0
    Circulo cir2 = new Circulo(10.0);

    //  Se crea el objeto cuad1 de la clase Cuadrado
    //con lado 12.0
    Cuadrado cuad1 = new Cuadrado(12.0);
     
    //  Se crea el objeto cuad2 de la clase Cuadrado
    //con lado 6.0
    Cuadrado cuad2 = new Cuadrado(6.0);

    //  Se crea el objeto rect1 de la clase Rectangulo
    //con el primer lado 7.0 y el segundo 3.0
    Rectangulo rect1 = new Rectangulo(7.0, 3.0);
     
    //  Se crea el objeto rect1 de la clase Rectangulo
    //con el primer lado 3.0 y el segundo 7.0
    Rectangulo rect2 = new Rectangulo(3.0, 7.0);
     
     //Sacar los datos de los objetos creados
    //los circulos
    System.out.println(cir1.toString());
    System.out.println(cir2.toString());

    //los cuadrados
    System.out.println(cuad1.toString());
    System.out.println(cuad2.toString());

    //los rectangulos
    System.out.println(rect1.toString());
    System.out.println(rect2.toString());
    }
    
}
