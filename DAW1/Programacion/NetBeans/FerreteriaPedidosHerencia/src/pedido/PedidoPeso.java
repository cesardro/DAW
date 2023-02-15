package pedido;
public class PedidoPeso extends Pedido{
    
    private double peso;

    //Constructor
    public PedidoPeso(String idProducto, double precioUnitario, double peso) {
        super(idProducto, precioUnitario);
        this.peso = peso;
    }

    //Getter & Setter
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    //toString
    @Override
    public String toString() {
        return "PedidoPeso{" + "peso=" + peso + '}';
    }
    
    public double precio(){
        double costePrecio = calcPrecio(peso);
        return costePrecio;
    }
}
