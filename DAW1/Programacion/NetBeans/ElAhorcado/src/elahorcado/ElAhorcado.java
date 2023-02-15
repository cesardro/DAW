package elahorcado;
import java.util.Scanner;
public class ElAhorcado {
    
    //Lista de palabras para adivinar.
    static String[] coleccion = {"manzana","pera","aguacate","platano","kiwi","mango","papaya"};
    
    //Palabra para adivinar cada que se inicia un juego. 
    static String palabra = "";
    
    //Array que contendrá guiones para ser substituidos por las letras adivinadas.
    static String[] letrasAdivinadas;
    
    //Scanner system in. 
    static Scanner sc;
    
    //Las vidas con las que cuenta el juegador en cada juego. 
    static int vidas=7;
    
    //Aqui se guarda las letras que hemos usado durante el juego. 
    static String letrasUsadas ="";
    
    public static void main(String[] args) {
        
        sc = new Scanner(System.in);
        
        System.out.println("+++EL AHORCADO+++");
        
        do{
            //Llamado de función:
            jugar();
            
            System.out.print("¿Quieres jugar otra vez? (S/N): ");    
        }while(sc.next().toUpperCase().equals("S"));
        System.out.println("Juego terminado.");
    }
    
    //Selecciona una palabra y empieza a preguntar por letras hasta adivinar
    //todas las letras o perder todas las vidas.
    public static void jugar() {
        
        System.out.println("Que comience el juego...");
        
        palabra = escogerPalabra();
        
        pintarPalabra();
        
        rellenarLetrasAdivinadas();
        
        vidas=7;

        while(comprobarFin()){
            
            System.out.print("Escribe una letra: ");
            String letra = sc.next();
            
            if(letrasUsadas.contains(letra)){
                System.out.println("Ya has usado esa letra.");
            }else{
                letrasUsadas += letra+" ";
            }
            
            System.out.println("Las letras que has usado son: "+letrasUsadas);

            if(palabra.contains(letra)){
                for (int i = 0; i < palabra.length(); i++) {
                    if(palabra.charAt(i)==letra.charAt(0)){
                        letrasAdivinadas[i]=letra;
                    }
                    System.out.print(letrasAdivinadas[i]+" ");
                }
                System.out.println("");
            }else{
                vidas--;
                dibujarAhorcado();
                System.out.println("Te quedan "+vidas+" vidas.");
            }
        }
        if(vidas==0){
            System.out.println("Has perdido.");
        }
        letrasUsadas="";
    }
    
    //Esta función escoge una palabra random de la colección de palabas 
    //que tenemos y la devuelve.
    public static String escogerPalabra() {
        int myRandom = (int)(Math.random()*coleccion.length);
        return coleccion[myRandom];
    }
    
    //Pinta la palabra como guiones.
    public static void pintarPalabra(){
        for(int i=0; i<palabra.length(); i++){
            System.out.print("_ ");
        }
        System.out.println("");
    }
    
    //Comprueba las vidas que tenemos.
    public static boolean comprobarFin(){
        boolean resp = true;
        
        if(vidas>0){
            boolean cont=false;
            for (int i = 0; i < letrasAdivinadas.length; i++) {
                if(letrasAdivinadas[i].equals("_")){
                    cont=true;
                    break;
                }
            }
            if(cont==false){
                resp=false;
                System.out.println("Has ganado.");
            }
        }else{
            resp = false;
        }
        return resp;
    }
    
    //Rellena el array de guiones con las letras que hayamos adivinado.
    public static void rellenarLetrasAdivinadas(){
        letrasAdivinadas = new String[palabra.length()];
        for(int i=0; i<palabra.length();i++){
            letrasAdivinadas[i]="_";
        }
    }
    
    public static void dibujarAhorcado(){
        switch(vidas){
            case 6:
                System.out.println(" |");
                break;
            case 5:
                System.out.println(" |");
                System.out.println(" 0");
                break;
            case 4:
                System.out.println(" |");
                System.out.println(" 0");
                System.out.println(" |");
                break;
            case 3:
                System.out.println(" |");
                System.out.println(" 0");
                System.out.println(" |");
                System.out.println("/|\\");
                break;
            case 2:
                System.out.println(" |");
                System.out.println(" 0");
                System.out.println(" |");
                System.out.println("/|\\");
                System.out.println(" |");
                break;
            case 1:
                System.out.println(" |");
                System.out.println(" 0");
                System.out.println(" |");
                System.out.println("/|\\");
                System.out.println(" |");
                System.out.println("/ ");
                break;
            case 0:
                System.out.println(" |");
                System.out.println(" 0");
                System.out.println(" |");
                System.out.println("/|\\");
                System.out.println(" |");
                System.out.println("/ \\");
                break;
        }
    }
}
