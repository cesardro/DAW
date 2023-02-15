package registroincidencias;
import java.util.ArrayList;
import java.util.Scanner;
public class RegistroIncidencias {
    
    static ArrayList<Incidencias> listaIncidencias;
    
    static Scanner sc = new Scanner(System.in);
    static String resp = "";
    static int contadorId = 0;
    
public static void main(String[] args) {
    
        contadorId = 0;
        
        listaIncidencias = new ArrayList<Incidencias>();
        
        System.out.println("************ BIENVENIDO ************");
        
        do{
        System.out.println("Selecciona una operación: ");
        System.out.println("1.- Crear incidencia.\n2.- Listar incidencia.\n3.- Modificar incidencia\n4.- Borrar incidencia.\n0.- Salir.");
        
        resp = sc.nextLine();
        
        switch (resp){
            case "1":
                crearIncidencia();
                break;
            case "2":
                listarIncidencia();
                break;
            case "3":
                modificarIncidencia();
                break;
            case "4":
                borrarIncidencia();
                break;
            case "0":
                System.out.println("Fin de la aplicación.");
                break;
            default:
                System.out.println("Opción no soportada.");
                break;
        }
        
        }while(!resp.equals("0"));
    }

    private static void crearIncidencia() {
        
        System.out.println("\n==============================");
        System.out.println("CREANDO INCIDENCIA...");
        
        System.out.print("Nombre: ");
        String nom = sc.nextLine();
        
        System.out.print("Descripción: ");
        String desc = sc.nextLine();
        
        System.out.print("Localización: ");
        String loc = sc.nextLine();
        
        listaIncidencias.add(new Incidencias(contadorId, nom, desc, loc));
        
        contadorId++; //Aumenta el contador de ID de incidencias.
       
        System.out.println("==============================\n");
    }

    private static void listarIncidencia() {
        
        System.out.println("\n==============================");
        System.out.println("Tamaño de la lista de incidencias: "+listaIncidencias.size());
        for (int i = 0; i < listaIncidencias.size(); i++) {
            System.out.println("******************************");
            System.out.println("Nombre: "+listaIncidencias.get(i).getNombre());
            System.out.println("Descripción: "+listaIncidencias.get(i).getDescripcion());
            System.out.println("Localización: "+listaIncidencias.get(i).getLocalizacion());
            System.out.println("Estado: "+listaIncidencias.get(i).getEstado());
            System.out.println("Responsable: "+listaIncidencias.get(i).getAsignadoA());
        }
        System.out.println("******************************");
        System.out.println("==============================\n");
    }

    private static void modificarIncidencia() {
        
        System.out.println("\n==============================");
        for (int i = 0; i < listaIncidencias.size(); i++) {
            System.out.println("******************************");
            System.out.println("ID: "+listaIncidencias.get(i).getId()+" - Nombre: "+listaIncidencias.get(i).getNombre());
        } 
        System.out.println("******************************\n");
        System.out.println("¿Qué indicendia quiere modificar?");
        String incMod = sc.nextLine();
        
        //Convertir la cadena de texto en un int.
        int m = Integer.parseInt(incMod);
        
        int i = 0;
        for (i = 0; i < listaIncidencias.size(); i++) {
            if(listaIncidencias.get(i).getId() == m){
                break;
            }
        }
        Incidencias incModificar = listaIncidencias.get(i);
        System.out.println("¿Que quieres hacer?");
        System.out.println("1.- Modificar el estado.\n2.- Asignar.\n3.- Localización.\n0.- Salir");
        String mod = sc.nextLine();
        switch(mod){
            case "1":
                System.out.print("Nuevo estado: ");
                resp = sc.nextLine();
                incModificar.setEstado(mod);
                break;
            case "2":
                System.out.print("Asignar a: ");
                resp = sc.nextLine();
                incModificar.setAsignadoA(mod);
                break;
            case "3":
                System.out.print("Nueva localización: ");
                resp = sc.nextLine();
                incModificar.setLocalizacion(mod);
                break;
            case "0":
                break;
            default:
                System.out.println("Operación no soportada.");
                break;
        }
    }

    private static void borrarIncidencia() {
        
        System.out.println("\n==============================");
        for (int i = 0; i < listaIncidencias.size(); i++) {
            System.out.println("******************************");
            System.out.println("ID: "+listaIncidencias.get(i).getId()+" - Nombre: "+listaIncidencias.get(i).getNombre());
        } 
        System.out.println("******************************\n");
        System.out.println("¿Qué indicendia deseas borrar? (ID)");
        String incBorrar = sc.nextLine();
        
        //Convertir la cadena de texto en un int.
        int r = Integer.parseInt(incBorrar);
        
        int i = 0;
        for (i = 0; i < listaIncidencias.size(); i++) {
            if(listaIncidencias.get(i).getId() == r){
                break;
            }
        }
     
        listaIncidencias.remove(i);
        System.out.println("Incidencia borrada: "+i);
        System.out.println("==============================");
    }    
}
