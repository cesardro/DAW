package pedido;
public class Pedido {
    
    protected String idProducto;
    protected double precioUnitario;

    //Constructor
    public Pedido(String idProducto, double precioUnitario) {
        this.idProducto = idProducto;
        this.precioUnitario = precioUnitario;
    }

    //Getter & Setter
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    //toString
    @Override
    public String toString() {
        return "Pedido{" + "idProducto=" + idProducto + ", precioUnitario=" + precioUnitario + '}';
    }
    
    public double calcPrecio(double unidades){
        double precio = unidades*precioUnitario;
        return precio;
    }
}
