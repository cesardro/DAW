package jugador;
public class JAmateur extends Jugador{
    
    private String nombreTutor;
    private String apellidosTutor;
    
    //Constructor
    public JAmateur(String nombreTutor, String apellidosTutor, String nombre, String apellidos) {
        super(nombre, apellidos);
        this.nombreTutor = nombreTutor;
        this.apellidosTutor = apellidosTutor;
    }
    
    //Getter & Setter
    public String getNombreTutor() {
        return nombreTutor;
    }

    public void setNombreTutor(String nombreTutor) {
        this.nombreTutor = nombreTutor;
    }

    public String getApellidosTutor() {
        return apellidosTutor;
    }

    public void setApellidosTutor(String apellidosTutor) {
        this.apellidosTutor = apellidosTutor;
    }

    @Override
    public String toString() {
        return "JAmateur{" + "nombreTutor=" + nombreTutor + ", apellidosTutor=" + apellidosTutor + '}';
    }    
}
