package cadenascaracteres;
import java.util.Scanner;
public class CadenasCaracteres {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una frase: ");
        
        String[] porPalabra = sc.nextLine().split(" ");
        
        for (int i=0; i < porPalabra.length; i++){          
                for(int j= porPalabra[i].length()-1; j >= 0; j--){
                    
                    System.out.print(porPalabra[i].charAt(j));
                }              
                System.out.print(" ");
        }
    }
}