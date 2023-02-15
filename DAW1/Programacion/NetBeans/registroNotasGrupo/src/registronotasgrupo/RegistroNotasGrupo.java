package registronotasgrupo;
import java.util.ArrayList;
import java.util.Scanner;
public class RegistroNotasGrupo {
    
    private static Scanner sc;
    private static ArrayList<Grupo> listaGrupo;
    
    public static void main(String[] args) {
        
        sc = new Scanner(System.in);
        listaGrupo = new ArrayList<Grupo>();
        
        String resp = "";
        
        
        System.out.println("**** Registro de notas de grupo ****");
        
        do{
            System.out.print("1.- Crear grupo\n2.- Listado\n0.- Salir\nOpcion: ");
            resp = sc.nextLine();
            switch(resp){
                case "1":
                    crearLista();
                    break;
                case "2":
                    listado();
                    break;
                case "0":
                    System.out.println("Fin de aplicacion.");
                    break;
                default:
                    System.out.println("Opcion no contemplada.");
                    break;
            }
        }while(!resp.equals("0"));
    }

    private static void crearLista() {
        System.out.println("\n***Creando lista...***");
        
        System.out.println("Crear grupo\nPara salir introducir 0.");
        
        boolean noMasGrupos = true;
        do{
            System.out.print("\nNombre de grupo: ");
            String nombreGrupo = sc.nextLine();
            if(nombreGrupo.equals("0")){
                noMasGrupos = false;
            }else{
                Grupo grp = new Grupo(nombreGrupo);
                listaGrupo.add(grp);
                grp.crearAlumno();
            }  
        }while(noMasGrupos);  
    }

    private static void listado() {
        for(Grupo grp:listaGrupo){
            grp.listado();
        }
    }
    
}
