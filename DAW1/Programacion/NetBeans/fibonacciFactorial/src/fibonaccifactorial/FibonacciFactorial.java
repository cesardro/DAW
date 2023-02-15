package fibonaccifactorial;
import java.util.Scanner;
public class FibonacciFactorial {
    
    //Scanner para preguntar información.
    static Scanner sc;
    
    //Función principal que llama a 4 funciones.
    public static void main(String[] args) {
        sc = new Scanner(System.in); 
        
        System.out.println("Bienvenido a Fibonacci & Factorial.");
        
        do{
            int myNum = ingresarNumero();
            int opc = queCalcular();
            switch(opc){
                case 1:
                    calcularFibonacci(myNum);
                    break;
                case 2:
                    calcularFactorial(myNum);
                    break;
                default:
                    break;
            }
            System.out.println("\n¿Quieres calcular con otro número? (S/N)");
        }while(sc.next().toUpperCase().equals("S"));
    }
    
    //Función para ingresar número entre 3 y 15. 
    //Un do while para verificar que escoja entre 3 y 15 (incluendolos)
    public static int ingresarNumero(){
        boolean x;
        int preg;
        do{
            System.out.print("Ingresar un número entre 3 y 15: ");
            preg = sc.nextInt(); 
            if(preg >= 3 && preg <= 15){
                x=false;
            }else{
                System.out.print("Número incorrecto. ");
                x=true;
            }
        }while(x);
        return (preg);
    }
    
    //Función para escoger entre Fibonacci y Factorial.
    //Un do while para verificar que escoja entre la opcion 1 o 2.
    public static int queCalcular(){
        boolean x;
        int opc;
        do{
            System.out.print("Por favor escoge tú opción:\n1. Fibonacci\n2. Factorial\n");
            opc = sc.nextInt(); 
            if(opc==1 || opc ==2){
                x=false;
            }else{
                System.out.println("Opción incorrecta.");
                x=true;
            }
        }while(x);
        return(opc);
    }
    
    //Función para calcular el Fibonacci.
    //Tiene 3 variables que se van sumando entre ellas en
    //secuencia para simular Fibonacci.
    public static void calcularFibonacci(int myNum){
        System.out.println("La sucesión de Fibonacci de "+myNum+" elementos es:");
        int num1=0, num2=1, suma=1;
        for (int i = 0; i < myNum; i++) {
            System.out.print(suma+" ");
            suma=num1+num2;
            num1=num2;
            num2=suma;
        }
    }
    
    //Función para calcular el Factorial.
    //Tiene 1 variable que se multiplica al principio por 2 y despues
    //con el for se va multiplicando progresivaente guardando el numero anterior.
    public static void calcularFactorial(int myNum){
        int acum=1;
        for (int i = 2; i <= myNum; i++) {
            acum = acum * i;
        }
        System.out.println("El factorial del número "+myNum+" es "+acum);
    }
}
