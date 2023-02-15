package registronotasgrupo;

import java.util.ArrayList;
import java.util.Scanner;

public class Grupo {
    
    private String nombreGrupo;
    Scanner sc;
    
    ArrayList<Alumno> listaAlumno;

    public Grupo(String nombreGrupo){
        this.nombreGrupo = nombreGrupo;
        listaAlumno = new ArrayList<Alumno>();
    }

    public void crearAlumno(){
        
        sc = new Scanner(System.in);
        
        System.out.println("Crear alumno\nPara salir introducir 0.");
  
        boolean noMasAlumnos = true;
        do{
            System.out.print("\nNombre de alumno: ");
            String preg = sc.next();
            if(preg.equals("0")){
                noMasAlumnos = false;
            }else{
                Alumno al = new Alumno(preg);
                listaAlumno.add(al);
                al.crearNota();
            }  
        }while(noMasAlumnos);
    }
    
    public void listado(){
        System.out.println(this.nombreGrupo);
        for(Alumno al:listaAlumno){
            al.listado();
        }
    }
}
