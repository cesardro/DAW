package demofile;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DemoFile {
    
    static Scanner sc = new Scanner(System.in);
    static String baseDir = "C:\\Users\\zx21student278\\Desktop";
    
    public static void main(String[] args) {
                        
        System.out.print("Dime el nombre de la carpeta: ");
        String carpeta = sc.nextLine();
        
        File carpPadre = new File(baseDir, carpeta);
        
        if (carpPadre.exists()) {
            menu(carpPadre);
        }else{
            crearCarpeta(carpPadre);
        }
    }
    
    
    public static void menu(File carpPadre){
        
        System.out.println("** Menu **");
        String resp;
        do {
            
            System.out.println("\n1. Listar Contenido.\n2. Crear carpeta. \n3. Crear fichero.\n0. Salir.\n");
            System.out.print("Selecciona una opción: ");
            resp = sc.nextLine();
            switch(resp){
                case "1":
                    listado(carpPadre);
                    break;
                case "2":
                    crearSubCarpeta(carpPadre);
                    break;
                case "3":
                    crearFichero(carpPadre);
                    break;
                case "0":
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("**** Opción no contemplada. *****");
                    break;
            }
        } while (!resp.equals("0"));
        
    }
    
    public static void crearCarpeta(File carpPadre){
        
        System.out.println("¿Quieres crear una carpeta? Si / No");
        String resp = sc.nextLine();
        if(resp.toLowerCase().equals("si")){
            System.out.println(carpPadre.getAbsolutePath());
            carpPadre.mkdir();
        }
    }
    
    public static void listado(File carpPadre){
        
        System.out.println("");
        String[] listado = carpPadre.list();
        for(String nombre : listado){
            File f = new File(carpPadre.getAbsolutePath(), nombre);
            if(f.isDirectory()){
                System.out.println(nombre + " es un directorio/carpeta. Y el tamaño es: " + f.length());
            }else{
                System.out.println(nombre + " es un archivo/fichero. Y el tamaño es: " + f.length());
            }
        }
        
    }

    public static void crearSubCarpeta(File carpPadre) {
        
        System.out.println("");
        System.out.print("Introduce un nombre: ");
        String nomSubCarpeta = sc.nextLine();
        File subCarp = new File(carpPadre.getAbsolutePath(), nomSubCarpeta);
        subCarp.mkdir();
    }

    public static void crearFichero(File carpPadre) {
        
        System.out.println("");
        System.out.print("Nombre del fichero: ");
        String nomFichero = sc.nextLine();
        
        File ficheroNuevo = new File(carpPadre.getAbsolutePath(), nomFichero);
        
        try {
            ficheroNuevo.createNewFile();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
