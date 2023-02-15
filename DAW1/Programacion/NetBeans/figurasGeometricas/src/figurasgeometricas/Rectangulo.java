package figurasgeometricas;
public class Rectangulo {
    
    private double base;
    
    private double altura;
    
    public Rectangulo(double b, double a){
        if(b<0){
            base = 0;
        }else{
            base = b;
        }
        
        if(a<0){
            altura = 0;
        }else{
            altura = a;
        }
    }
    
    public double getBase(){
        return base;
    }
    
    public void setBase(double b){
        if(b<0){
            base = 0;
        }else{
            base = b;
        }
    }
    
    public double getAltura(){
        return altura;
    }
    
    public void setAltura(double a){
        if(a<0){
            altura = 0;
        }else{
            altura = a;
        }
    }
    
    public double perimetro(){
        double perimetro = 0;
        perimetro = 2*(base+altura);
        return perimetro;
    }
    
    public double area(){
        double area = 0;
        area = base*altura;
        return area;
    }
}
