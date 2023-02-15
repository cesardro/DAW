package figurasgeometricas;

public class FigurasGeometricas {
    
    public static void main(String[] args) {
        //Crear un circulo.
        
        Circulo c1 = new Circulo(5);
        
        //c2 ----> radio 10
        Circulo c2 = new Circulo(10);
        //c3 ----> radio 15
        Circulo c3 = new Circulo(15);
        
        //Datos de un ciruclo de radio 5.
        c1.getRadio();
        System.out.println("El área del circulo es: "+c1.area());
        System.out.println("El perímetro del círculo es: "+c1.perimetro());
        
        //Datos de un circulo de radio 10.
        c2.getRadio();
        System.out.println("El área del circulo es: "+c2.area());
        System.out.println("El perímetro del círculo es: "+c2.perimetro());
        
        //Datos de un circulo de radio 15.
        c3.getRadio();
        System.out.println("El área del circulo es: "+c3.area());
        System.out.println("El perímetro del círculo es: "+c3.perimetro());
        
        
        //TAREA
        /*
        Crear la clase rectangulo y la clase cuadrado
        usarlas en este main con tres objetos de cada clase.
        */
        
        
        //Primer valor base, segundo altura.
        Rectangulo r1 = new Rectangulo(10,5);
        
        r1.getAltura();
        r1.getBase();
        System.out.println("El área del rectangulo es: "+r1.area());
        System.out.println("El perimetro del rectangulo es: "+r1.perimetro());
       
        Cuadrado cu1 = new Cuadrado(4);
        
        cu1.getLado();
        System.out.println("El área del cuadrado es: "+cu1.area());
        System.out.println("El perimetro del cuadrado es: "+cu1.perimetro());
    }
    
}
