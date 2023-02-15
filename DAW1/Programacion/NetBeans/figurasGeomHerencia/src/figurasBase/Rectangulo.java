package figurasBase;
public class Rectangulo extends Figura{
    
    private double lado1, lado2;
    
    //Constructor

    public Rectangulo(double lado1, double lado2) {
        
        super(lado1*lado2,(lado1*2)+(lado2*2));
        
        this.lado1 = lado1;
        this.lado2 = lado2;
    }
    
    //Getter & Setter

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
        this.area = this.lado1*this.lado2;
        this.perimetro = (this.lado1*2)+(this.lado2*2);
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
        this.area = this.lado1*this.lado2;
        this.perimetro = (this.lado1*2)+(this.lado2*2);
    } 
}
