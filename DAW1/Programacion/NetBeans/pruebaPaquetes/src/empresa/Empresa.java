package empresa;

import java.util.ArrayList;
import persona.Persona;

public class Empresa {
    
    //Atributos de la clase
    public String nombre;
    public ArrayList<Persona> listaPersonas = new ArrayList<>();
    
    //Constructor
    public Empresa(String nombre) {
        this.nombre = nombre;
    }
    
    //Getter & Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //toString
    @Override
    public String toString() {
        
        String resp = "Nombre de Empresa: " + nombre;
        for (int i = 0; i < listaPersonas.size(); i++) {
            resp = resp + "\n" + listaPersonas.get(i).toString(); 
        }
        
        /* //Forma mas optima de hacer lo de arriba. 
        for(Persona pers : listaPersonas){
            resp = resp + "\n" + pers.toString();
        }
        */
        
        return resp;
        
    }
    
    //Metodo para añadiruna persona a la empresa
    public void aniadirPersona(String nombre, String apellido, String correo){
        
        listaPersonas.add(new Persona(nombre, apellido, correo));
    }
}
