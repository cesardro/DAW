package registronotasgrupo;

import java.util.ArrayList;
import java.util.Scanner;

public class Alumno {
    
    private String nombreAlumno;
    ArrayList<Nota> listaNota;
    static Scanner sc;

    public Alumno(String nombreAlumno) {
        
        this.nombreAlumno = nombreAlumno;
        listaNota = new ArrayList<Nota>();
    }

    public void crearNota() {
        System.out.println("Crear asignatura y notas.\nPara salir introducir 0.");
        sc = new Scanner(System.in);
        
        boolean noMasNotas = true;
        do{
            System.out.print("\nAsignatura: ");
            String preg = sc.next();
            if(preg.equals("0")){
                noMasNotas = false;
            }else{
                System.out.print("\nNota: ");
                int notaObtenida = sc.nextInt();
                Nota not = new Nota(preg, notaObtenida);
                listaNota.add(not);
            }
        }while(noMasNotas);
    }
    
    public void listado(){
        System.out.println("\t"+this.nombreAlumno);
        for(Nota not:listaNota){
            not.listado();
        }
    }
}
