package agenda;

import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    
    private static ArrayList<Persona> agenda;
    
    private static Scanner sc;
    
    public static void main(String[] args) {
        
        agenda = new ArrayList<>();
        sc = new Scanner(System.in);
        String resp;
        
        System.out.println("\n=================== Agenda de contactos ===================");
        
        do{
            
            System.out.println("1.- Crear contacto en la agenda.");
            System.out.println("2.- Listado de la agenda.");
            System.out.println("0.- Salir.");
            System.out.print("Selecciona una opción: ");
            resp = sc.nextLine();
            
            switch(resp){
                case "1":
                    crearPersona();
                    break;
                case "2":
                    listadoPersonas();
                    break;
                case "0":
                    System.out.println("Gracias por usar nuestros servicios...");
                    break;
                default:
                    System.out.println("Opción no comtemplada.");
                    break;
            }
            
        }while(!resp.equals("0"));
    }

    private static void crearPersona() {
        
        System.out.println("\n======================================");
        System.out.println("Crear un contacto para la agenda.");
        
        System.out.print("Nombre: ");
        String n = sc.nextLine();
        
        System.out.print("Apellidos: ");
        String a = sc.nextLine();
        
        System.out.print("Teléfono: ");
        String t = sc.nextLine();
        
        System.out.print("E-mail: ");
        String e = sc.nextLine();
        
        Direccion d = crearDireccion();
        
        /* //Esto es lo que normalmente se usa pero abajo esta simplificado.//
        Persona p = new Persona(n, a, t, e, d);
        agenda.add(p);
        */
        
        agenda.add(new Persona(n, a, t, e, d)); 
    }

    private static Direccion crearDireccion() {
        
        System.out.println("\n======================================");
        System.out.println("Crear una dirección.");
        
        System.out.print("Tipo de calle: ");
        String tc = sc.nextLine();
        
        System.out.print("Nombre de calle: ");
        String nc = sc.nextLine();
        
        System.out.print("Portal: ");
        String p = sc.nextLine();
        
        System.out.print("Piso, escalera, número...: ");
        String s = sc.nextLine();
        
        System.out.print("Código Postal: ");
        String cp = sc.nextLine();
        
        System.out.print("Localidad: ");
        String l = sc.nextLine();
        
        System.out.print("Provincia: ");
        String pr = sc.nextLine();
        
        System.out.print("País: ");
        String pa = sc.nextLine();
        
        return (new Direccion(tc, nc, p, s, cp, l, pr, pa));
    }
        
    private static void listadoPersonas() {
        
        System.out.println("\n======================================");
        System.out.println("Listado de contactos de la agenda.");
        
        for(Persona p:agenda){
            System.out.println("\n======================================");
            System.out.println(p.toString());
            System.out.println("\n======================================");
        }
        /*
        for (int i = 0; i < agenda.size(); i++) {
            System.out.println(agenda.get(i).toString());
        }
        */
    }
}
