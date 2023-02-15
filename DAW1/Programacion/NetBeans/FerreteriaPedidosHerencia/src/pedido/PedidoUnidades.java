package pedido;
public class PedidoUnidades extends Pedido{
    
    private double unidades;

    //Constructor
    public PedidoUnidades(String idProducto, double precioUnitario, double unidades) {
        super(idProducto, precioUnitario);
        this.unidades = unidades;
    }

    //Getter & Setter
    public double getUnidades() {
        return unidades;
    }

    public void setUnidades(double unidades) {
        this.unidades = unidades;
    }

    //toString
    @Override
    public String toString() {
        return "PedidoUnidades{" + "unidades=" + unidades + '}';
    }
    
    public double precio(){
        double costePedido = calcPrecio(unidades);
        return costePedido;
    }
}
