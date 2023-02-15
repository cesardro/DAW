package registroincidencias;
public class Incidencias {
    
    private int id = 0; //Para guarda el identificador.
    private String nombre = ""; //Nombre de la incidencia.
    private String descripcion = ""; //Descripción de la incidencia.
    private String estado = ""; //Estado de dicha.
    private String asignadoA = ""; //Asignación al personal.
    private String localizacion = ""; //Localización de la incidencia.
    
    //Constructor de la clase
    public Incidencias(int i, String n, String d, String l){
        
        this.id = i; //Se guarda el identificador de la incidencia.
        this.nombre = n; //Se guarda el nombre de la incidencia.
        this.descripcion = d; // Se guarda la descripción de la incidencia.
        this.localizacion = l; //Se guarda la localización de la incidencia.
        this.estado = "Creada"; //Se pone en estado creada.    
    }

    //++++++++++++++++++++++ set & get Id ++++++++++++++++++++++
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //++++++++++++++++++++++ set & get Nombre ++++++++++++++++++++++
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //++++++++++++++++++++++ set & get Descripcion ++++++++++++++++++++++
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //++++++++++++++++++++++ set & get Estado ++++++++++++++++++++++
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //++++++++++++++++++++++ set & get Asignado ++++++++++++++++++++++
    public String getAsignadoA() {
        return asignadoA;
    }

    public void setAsignadoA(String asignadoA) {
        this.asignadoA = asignadoA;
    }

    //++++++++++++++++++++++ set & get Localizacion ++++++++++++++++++++++
    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }
    
}
