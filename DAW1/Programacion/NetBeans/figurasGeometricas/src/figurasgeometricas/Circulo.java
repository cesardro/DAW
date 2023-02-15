package figurasgeometricas;
public class Circulo {
    
    //Atributo con el radio del circulo.
    private double radio;
    
    //Constructor de la clase.
    public Circulo(double r){
        if(r<0){
            radio = 0;
        }else{
            radio = r;
        }
    }
    
    //Métodos Get y Set.
    public double getRadio(){
        return radio;
    }
    
    //Modifica el valor del radio.
    public void setRadio(double r){
        if(r<0){
            radio = 0;
        }else{
            radio = r;
        }
    }
    
    //Metodo para calcular el perimetro de un circulo.
    public double perimetro(){
        double circunferencia = 0; //Variable para guardar el perimetro del círculo
        
        circunferencia = 2*radio*Math.PI; //Calculo del perimetro.
        
        return circunferencia; //Devolver el perimetro.
    }
    
    //Metodo para calcular el area de un circulo.
    public double area(){
        double area = 0;
        
        area = Math.PI*radio*radio;
        
        return area;
    }
}
