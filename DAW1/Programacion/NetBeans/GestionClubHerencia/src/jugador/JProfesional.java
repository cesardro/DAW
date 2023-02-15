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
public class JProfesional extends Jugador{
    
    private double salario;
    
    //Constructor
    public JProfesional(String nombre, String apellidos, double salario) {
        super(nombre, apellidos);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "JProfesional{" + "salario=" + salario + '}';
    }
    
    
}
