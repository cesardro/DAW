package operarfracciones;
public class OperarFracciones {
    
    
    public static void main(String[] args) {
        Fraccion f1 = new Fraccion(1,2);
        Fraccion f2 = new Fraccion(1,4);
        
        Fraccion resMulti = f1.multiplicacion(f2);
        
        System.out.println("Resultado de multiplicar "+
                        f1.toString() + " por "+
                        f2.toString()+" es: "+
                        resMulti.toString());
        
        Fraccion resDivi = f1.division(f2);
        System.out.println("Resultado de dividir "+
                        f1.toString() + " por "+
                        f2.toString()+" es: "+
                        resDivi.toString());
        
        Fraccion resSuma = f1.suma(f2);
        System.out.println("Resultado de sumar "+
                        f1.toString() + " por "+
                        f2.toString()+" es: "+
                        resSuma.toString());
        
        Fraccion resResta = f1.resta(f2);
        System.out.println("Resultado de restar "+
                        f1.toString() + " por "+
                        f2.toString()+" es: "+
                        resResta.toString());
    }
    
}
