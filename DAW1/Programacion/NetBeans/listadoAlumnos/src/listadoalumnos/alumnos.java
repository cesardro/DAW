package listadoalumnos;
public class alumnos {
    
    private String nombre;
    private String ciclo;
    private String curso;

    public alumnos(String nombre, String ciclo, String curso) {
        this.nombre = nombre;
        this.ciclo = ciclo;
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
