package operarfracciones;
public class Fraccion {
    
    //Atributos (numerador de la fracción y denominador de la fracción)
    private int numerador, denominador;

    //Contructor
    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion() {
    }
    
    //Getter & Setter de Numerador
    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    //Getter & Setter de Denominador
    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }
    
    public Fraccion suma(Fraccion f){
        
        Fraccion fRes = new Fraccion();
        
        if(this.getDenominador() == f.getDenominador()){  
            fRes.setNumerador(this.getNumerador()+f.getNumerador());
            fRes.setDenominador(this.getDenominador());
        }else{
            int mcm = minimoComunMultiplo(this.getDenominador(), f.getDenominador());
            
            int n1 = this.getNumerador();
            int d1 = this.getDenominador();
            int n2 = f.getNumerador();
            int d2 = f.getDenominador();
            
            
            int numRes = (n1 * (mcm/d1))+(n2 * (mcm/d2));
            
            fRes.setNumerador(numRes);
            fRes.setDenominador(mcm);
        }
        
        return fRes;
    }
    
    public Fraccion resta(Fraccion f){
        
        Fraccion fRes = new Fraccion();
        
        if(this.getDenominador() == f.getDenominador()){ 
            fRes.setNumerador(this.getNumerador()-f.getNumerador());
            fRes.setDenominador(this.getDenominador());
        }else{
            int mcm = minimoComunMultiplo(this.getDenominador(), f.getDenominador());
            
            int n1 = this.getNumerador();
            int d1 = this.getDenominador();
            int n2 = f.getNumerador();
            int d2 = f.getDenominador();
            
            
            int numRes = (n1 * (mcm/d1))-(n2 * (mcm/d2));
            
            fRes.setNumerador(numRes);
            fRes.setDenominador(mcm);
        }
        
        return fRes;
    }
    
    public Fraccion multiplicacion(Fraccion f){
        
        Fraccion fRes = new Fraccion();
        
        int numRes = this.getNumerador()*f.getNumerador();
        int denRes = this.getDenominador()*f.getDenominador();
        
        fRes.setNumerador(numRes);
        fRes.setDenominador(denRes);
        
        return fRes;
        
        /*    ******Esta seria la solución de un programador ******
        return new Fraccion(this.getNumerador()*f.getNumerador(),this.getDenominador()*f.getDenominador());
        */
    }
    
    public Fraccion division(Fraccion f){
        
        Fraccion fRes = new Fraccion();
        
        int numRes = this.getNumerador()*f.getDenominador();
        int denRes = this.getDenominador()*f.getNumerador();
        
        fRes.setNumerador(numRes);
        fRes.setDenominador(denRes);
        
        return fRes;
    }
    
    @Override
    public String toString() {
        return "("+this.numerador + " / " + this.denominador+")";
    }

    private int minimoComunMultiplo(int n1, int n2) {
        
        int res = 0;
        
        int max = Math.max(n1, n2);
        
        int[] listaN1 = new int[max];
        int[] listaN2 = new int[max];
        
        for (int i = 0; i < max; i++) {
            listaN1[i] = n1*(i+1);
            listaN2[i] = n2*(i+1);
        }
        
        boolean parada = false;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                if(listaN1[i] == listaN2[j]){
                    res = listaN1[i];
                    parada = true;
                    break;
                }
            }
            if(parada){
                break;
            }
        }
        
        return res;
    }
    
}

