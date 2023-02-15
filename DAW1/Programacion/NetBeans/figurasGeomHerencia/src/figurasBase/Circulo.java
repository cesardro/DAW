package figurasBase;

public class Circulo extends Figura{

    //Atributo
    private double radio;
    
    //Constructor
    public Circulo(double radio) {
        
        super(Math.PI*radio*radio, 2*Math.PI*radio);
        
        this.radio = radio;        
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
        this.area = Math.PI*this.radio*this.radio;
        this.perimetro = 2*Math.PI*this.radio;
    }
}
