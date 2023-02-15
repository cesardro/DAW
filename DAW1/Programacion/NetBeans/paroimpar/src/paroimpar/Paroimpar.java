package paroimpar;
import java.util.Scanner;
public class Paroimpar {
    public static void main(String[] args) {
        int num = 0 ,res = 0;
        Scanner preg = new Scanner(System.in);
        System.out.print("Ingrese número par o impar:");
        num = preg.nextInt();
        res = num%2;
        if(res == 0){
            System.out.println("Tu número es par.");
        }else{
            System.out.println("Tu número es impar.");
        }
    }
}
