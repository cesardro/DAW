package demoexcepciones;
public class DemoExcepciones {
    public static void main(String[] args) {
        
        int[] numeros = {1,2,3,4,5,6};
        
        Operacion op = new Operacion();
        
        try{
            op.division(1, 1);
            op.divisionArray(numeros);
            //op.demoLanzar();
            op.demoLanzar2();
        }catch(ArithmeticException x){
            
            System.out.println("Error aritmetico: " + x.getMessage());
        }catch(ArrayIndexOutOfBoundsException y){
            
            System.out.println("\nError de array: " + y.getMessage());
        }catch(RuntimeException j){
            
            System.out.println("Error RunTime: " + j.getMessage());
        }finally{
            
            System.out.println("Bloque finally.");
        }
        System.out.println("Estoy fuera del catch.");
    }
    
}
