/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugador;

/**
 *
 * @author zx21student278
 */
public class Jugador {
    
    protected String nombre;
    protected String apellidos;
    
    //Constuctor
    public Jugador(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
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

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", apellidos=" + apellidos + '}';
    }
    
    
}
