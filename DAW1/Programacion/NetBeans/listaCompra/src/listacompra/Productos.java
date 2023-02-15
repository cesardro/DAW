package listacompra;
public class Productos {
    
    private int id = 0; //Identificador único
    private String nombre = ""; //Nombre del producto
    private String cantidad = ""; //Cantidad del productor
    
    //Contructor de la clase
    public Productos(int id, String n, String c){
        this.id = id;
        this.nombre = n;
        this.cantidad = c;
    }
    
    // **************** Get & Set de ID ****************
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    // **************** Get & Set de Nombre ****************
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    // **************** Get & Set de Cantidad ****************
    public String getCantidad(){
        return cantidad;
    }
    
    public void setCantidad(String cantidad){
        this.cantidad = cantidad;
    }
}
