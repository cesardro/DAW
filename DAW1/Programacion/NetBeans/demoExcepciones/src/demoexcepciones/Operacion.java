package demoexcepciones;
public class Operacion {
    
    
    public int division(int a, int b){
        
        return a/b;
    }
    
    public void divisionArray(int[] numeros){
        for (int i = 0; i < numeros.length; i=i+2) {
            int r = numeros[i]/numeros[i+1];
            System.out.println(r);
        }
        
    }
    
    public void demoLanzar(){
        
        throw new RuntimeException("Excepcion del metodo demoLanzar");
    }
    
    public void demoLanzar2(){
        
        throw new IllegalArgumentException("Excepcion del metodo demoLanzar2");
    }
}
