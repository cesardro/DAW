package adivinarelnumero;
import java.util.Random;
import java.util.Scanner;
public class AdivinarElNumero {
    public static void main(String[] args) {
        
        int max = 100;
        int min = 1;
        
        Random randomNum = new Random();
        int myRandom = min + randomNum.nextInt(max);

        System.out.print("BIENVENIDO A ADIVINA EL NUMERO (1-100)\nIngresa número: ");
        Scanner sc = new Scanner(System.in);
        int myNum = sc.nextInt();
   
        while(myNum != myRandom){
            if(myNum < myRandom){
                System.out.println("¡Ese no es! Esta mas arriba");
            }else{
                System.out.println("No lo has adivinado ¡es más bajo!");
            }
            System.out.print("Ingresa otro número: ");
            myNum = sc.nextInt();
        }
        System.out.println("¡Enhorabuena ¡has ganado!");
    }
}
