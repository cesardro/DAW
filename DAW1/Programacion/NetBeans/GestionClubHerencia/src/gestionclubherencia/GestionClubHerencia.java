package gestionclubherencia;

import jugador.JAmateur;
import jugador.JProfesional;

public class GestionClubHerencia {
    public static void main(String[] args) {
        
    //crear jugador profesional
    JProfesional jpro1 = new JProfesional("Ana", "Lopez Lopez", 2000.0);  
     
    //crear jugador amateur
    JAmateur jamat1 = new JAmateur("Juan", "Garcia Garcia", "Pedro", "García Martínez");
     
    //sacar la información de cada jugador
    System.out.println(jpro1.toString());
    System.out.println(jamat1.toString());
    }
    
}
