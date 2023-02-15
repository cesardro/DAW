package datosdirectorio;
public class ElementoDir {
    
    private String nombre;
    private String dir;
    private long tam;

    public ElementoDir(String nombre, String dir, long tam) {
        this.nombre = nombre;
        this.dir = dir;
        this.tam = tam;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public long getTam() {
        return tam;
    }

    public void setTam(long tam) {
        this.tam = tam;
    }
    
    
    
}
