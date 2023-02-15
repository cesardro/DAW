package ordenararray;
public class OrdenarArray {
    public static void main(String[] args) {
        
        int[] uno = {1,6,3,2,9,0};
        imprimeNum(uno);
        System.out.println("");
        OrdenarBurbuja.burbuja(uno);
        imprimeNum(uno);
        System.out.println("\n");
        
        int[] dos = {8,4,1,6,9,2,7,0};
        imprimeNum(dos);
        System.out.println("");
        OrdenarBurbuja.burbujaAlReves(dos);
        imprimeNum(dos);
        System.out.println("\n");
        
        int[] tres = {81,42,11,60,93,28,75,30};
        imprimeNum(tres);
        System.out.println("");
        OrdenarBurbuja.insercion(tres);
        imprimeNum(tres);
        System.out.println("\n");
               
    }
    
    public static void imprimeNum(int[] listaNum){
        for (int i = 0; i < listaNum.length; i++) {
            System.out.print(listaNum[i]+" - ");
        }
    }
    
    
}
