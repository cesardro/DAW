package agenda;
public class Persona {
    
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;
    private Direccion direccion;
    
    //******************** Constructor ********************//
    public Persona(String n, String a, String t, String e, Direccion direccion){
        this.nombre = n;
        this.apellidos = a;
        this.telefono = t;
        this.email = e;
        this.direccion = direccion;
    }
    
    //******************** get & set Nombre ********************//
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //******************** get & set Apellidos ********************//
    public String getApellidos() {
        return apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    //******************** get & set Telefono ********************//
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    //******************** get & set E-Mail ********************//
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    //******************** get & set Direccion ********************//
    public Direccion getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String email) {
        this.direccion = direccion;
    }

    //******************** get & set toString ********************//

    @Override
    public String toString() {
        return "Persona" + "\n\t Nombre = " + nombre + "\n\t Apellidos = " + apellidos + "\n\t Teléfono = " + telefono + "\n\t E-mail = " + email + direccion.toString();
    }
       
}
