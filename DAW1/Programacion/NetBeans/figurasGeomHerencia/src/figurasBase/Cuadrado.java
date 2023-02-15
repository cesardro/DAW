package figurasBase;
public class Cuadrado extends Figura{
    
    //Atributo
    private double lado;
    
    //Constructor

    public Cuadrado(double lado) {
        
        super(lado*lado,lado*4);
        
        this.lado = lado;        
    }
    
    //Getter & Setter
    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
        this.area = this.lado*this.lado;
        this.perimetro = this.lado*4;
    }
}
