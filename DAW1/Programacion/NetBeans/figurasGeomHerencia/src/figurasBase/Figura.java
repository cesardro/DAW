package figurasBase;
class Figura {
    
    //Atributos
    protected double area; //Area de la figura.
    protected double perimetro; //Perimetro de la figura.
    
    //Constructor
    public Figura(double area, double perimetro) {
        this.area = area;
        this.perimetro = perimetro;
    }
    
    //Constructor 
    public Figura(){
    }
    
    //Getter & Setter
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    //toString
    @Override
    public String toString() {
        return "**Figura**\n" + "\tArea:" + area + "  // Perimetro: " + perimetro;
    }
    
}
