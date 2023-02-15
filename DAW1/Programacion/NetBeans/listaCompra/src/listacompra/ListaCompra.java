package listacompra;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaCompra {

    //Variables
    static Scanner sc = new Scanner(System.in);
    static String resp = "";
    static ArrayList<Productos> listaProductos; //Array List.
    static int contadorId = 0; //Contador ID único.

    //Main
    public static void main(String[] args) {

        contadorId = 0;
        listaProductos = new ArrayList<Productos>();
        System.out.println("***** BIENVENIDO *****");
        do {

            System.out.println("¿Que opción desea?");
            System.out.println("1. Crear producto.");
            System.out.println("2. Borrar producto.");
            System.out.println("3. Listar producto.");
            System.out.println("0. Salir.");
            resp = sc.nextLine();

            switch (resp) {
                case "1":
                    crearProducto();
                    break;
                case "2":
                    borrarProducto();
                    break;
                case "3":
                    listarProducto();
                    break;
                case "0":
                    System.out.println("Saliendo de programa...");
                    break;
                default:
                    System.out.println("Opción no contemplada.");
            }
        } while (!resp.equals("0"));

    }

    //Crea un producto con una clase y lo añade a un array list.
    private static void crearProducto() {
        
        System.out.println("\n========================");
        System.out.println("Creando producto...");
        
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        
        System.out.print("Cantidad: ");
        String cantidad = sc.nextLine();
        
        System.out.println("========================\n");
        
        listaProductos.add(new Productos(contadorId, nombre, cantidad));
        contadorId++; 
    }

    //Borra un producto del array list.
    private static void borrarProducto() {
        
        System.out.println("\n========================");
        for (int i = 0; i < listaProductos.size(); i++) {
            System.out.println("*********************");
            System.out.println("ID: "+listaProductos.get(i).getId()+" - Nombre: "+listaProductos.get(i).getNombre());    
        }
        System.out.println("*********************");
        System.out.println("¿Qué producto deseas borrar? (ID)");
        String proBorrar = sc.nextLine();
        
        int b = Integer.parseInt(proBorrar);
        
        int i = 0;
        for ( i = 0; i < listaProductos.size(); i++) {
            if(listaProductos.get(i).getId() == b){
                break;
            }
        }
        listaProductos.remove(i);
        System.out.println("Incidencia borrada: "+i);
        System.out.println("========================\n");
    }

    //Muestra la información que hay en el array list con clases.
    private static void listarProducto() {
        
        System.out.println("\n========================");
        System.out.println("Tamaño de la lista de la compra: "+listaProductos.size());
        
        for (int i = 0; i < listaProductos.size(); i++) {
            System.out.println("*********************");
            System.out.println("Nombre: "+listaProductos.get(i).getNombre());
            System.out.println("Cantidad: "+listaProductos.get(i).getCantidad());     
        }
        System.out.println("*********************");
        System.out.println("========================\n");
    }
}
