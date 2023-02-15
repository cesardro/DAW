package kaprekar;
import java.util.Arrays;
import java.util.Scanner;
public class Kaprekar {
    
    //Scanner system in.
    static Scanner sc;
    //Constante para Kaprekar.
    static final int KAPREKAR = 6174;
    //Variables generales en la cual myNum es el número introducido por el usuario,
    //mayor es myNum ordenador de Mayor a Menor y menor viceversa.
    static int myNum, mayor = 6174, menor = 6174;

    public static void main(String[] args) {
        
        sc = new Scanner(System.in);
        
        System.out.println("Bienvenido a Constante Kaprekar.");

        do {
            introducirNum();
            while(myNum!=KAPREKAR){
                mayor = convertirAMayor();
                menor = convertirAMenor();
                System.out.println(mayor+" - "+menor+" = "+myNum);
                myNum = mayor - menor;
            }
            System.out.println(mayor+" - "+menor+" = "+myNum);
            System.out.println("¿Volver a calcular número Kaprekar? (S/N)");
        } while (sc.next().toUpperCase().equals("S"));
    }

    //Función para introducir número y revisa el número.
    public static void introducirNum() {
        boolean x = true;
        do {
            System.out.print("Introduzca un número de 4 cifras: ");
            myNum = sc.nextInt();
            x = revisarMyNum(x);
        } while (!x);
    }

    //Revisa que el número introducido es correcto y cumple las reglas.
    public static boolean revisarMyNum(boolean x) {
        x = true;
        if(myNum <= 9999 && myNum > 0){
            int miles = myNum / 1000;
            int centenas = myNum / 100 % 10;
            int decenas = myNum / 10 % 10;
            int unidades = myNum % 10;
            if(miles == centenas && centenas == decenas && decenas == unidades){
                System.out.println("El número no puede tener cifras repetidas.");
                x=false;
            }
        }else{
            System.out.println("El número tiene que estar entre 1 y 9999.");
            x=false;
        }
        return (x);
    }
    
    //Ordena de Mayor a Menor los 4 digitos. 
    public static int convertirAMayor(){
        int m;
        int[] digitos = new int[4];
        Arrays.fill(digitos,0);
        digitos[0] = myNum / 1000;
        digitos[1] = myNum / 100 % 10;
        digitos[2] = myNum / 10 % 10;
        digitos[3] = myNum % 10; 
        Arrays.sort(digitos);
        m = digitos[3]*1000 + digitos[2]*100 + digitos[1]*10 + digitos[0];
        
        return m;
    }
    
    //Ordena de Menor a Mayor los 4 digitos.
    public static int convertirAMenor(){
        int m;
        int[] digitos = new int[4];
        Arrays.fill(digitos,0);
        digitos[0] = myNum / 1000;
        digitos[1] = myNum / 100 % 10;
        digitos[2] = myNum / 10 % 10;
        digitos[3] = myNum % 10; 
        Arrays.sort(digitos);
        m = digitos[0]*1000 + digitos[1]*100 + digitos[2]*10 + digitos[3];
        
        return m;
    }
}
