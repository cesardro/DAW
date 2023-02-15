/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registronotasgrupo;


/**
 *
 * @author zx21student278
 */
public class Nota {
    private String modulo;
    private int nota;

    public Nota(String modulo, int nota) {
        this.modulo = modulo;
        this.nota = nota;
    }
    public void listado(){
        System.out.println("\t\tAsignatura: "+this.modulo+" & Nota: "+this.nota);
    }
}
