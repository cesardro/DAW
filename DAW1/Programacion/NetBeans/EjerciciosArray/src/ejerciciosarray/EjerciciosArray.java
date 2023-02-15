package ejerciciosarray;
import java.util.Scanner;
public class EjerciciosArray {
    public static void main(String[] args) {
        
        //int [] edades = {12,32,56,3,57,53,11,32,25,18,66,1};
        
        
        int tam=0;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("¿Cuantas edades quieres introducir?");
        tam= sc.nextInt();
        
        int [] edades = new int[tam];
        
        for(int r=0; r<tam; r++){
            System.out.print("Introduzca el número: ");
            edades[r]=sc.nextInt();
        }
        
        int max=0;
        int cont=0;
        
        //Calculadora edad maxima con for
        for(int i=0; i<edades.length; i++){
            if(max<edades[i]){
                max=edades[i];
                cont=i;
            }
        }
        System.out.println("La maxima edad con for es: "+max);
        System.out.println("La posicion es: "+cont);
        
        //Calculadora edad maxima con for each
        max=0;
        for(int edad : edades){
            if(max<edad){
                max=edad;
            }
        }
        System.out.println("La maxima edad con for each es: "+max);
        
        //Calculadora minimo con for
        int min=200;
        for(int j=0; j<edades.length; j ++){
            if(min>edades[j]){
                min=edades[j];
                cont=j;
            }
        }
        System.out.println("La minima edad con for es: "+min);
        System.out.println("La posicion es: "+cont);
        
        //Calculadora minimo con for each
        min=200;
        for(int n : edades){
            if(min>n){
                min=n;
            }
        }
        System.out.println("La minima edad con for each es: "+min);
        
        //La media de edades con for
        float sumatorio=0;
        
        for(int k=0; k<edades.length; k++){
            sumatorio+=edades[k];
        }
        System.out.println("La media de edades con for es: "+(sumatorio/edades.length));
        
        //La media de edades con foreach
        sumatorio=0;
        
        for(int l : edades){
            sumatorio+=l;
        }
        System.out.println("La media de edades con for each es: "+(sumatorio/edades.length));
        
        //Cuantos pares hay en el array con for
        
        cont=0;
        for(int h=0; h<edades.length; h++){
            if(edades[h]%2 == 0){
                cont+=1;
            }
        }
        System.out.println("Hay un total de: "+cont+" pares sacado con for");
        
        //Cuantos pares hay en el array con for each
        
        cont=0;
        for(int y : edades){
            if(y%2 == 0){
                cont+=1;
            }
        }
        System.out.println("Hay un total de: "+cont+" pares sacado con for each");
    }
}
