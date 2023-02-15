package persona;

public class Persona {
    
    //Atributos de la clase
    public String nombre;
    public String apellidos;
    public String correo;
    
    //Constructor
    public Persona(String nombre, String apellidos, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
    }
    
    //Getter & Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    //toString
    @Override
    public String toString() {
        return "**Persona** " + "Nombre: " + nombre + ", Apellidos: " + apellidos + ", Correo: " + correo;
    }
    
    
    
}
