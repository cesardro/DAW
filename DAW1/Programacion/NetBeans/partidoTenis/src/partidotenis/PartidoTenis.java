package partidotenis;

import java.util.Scanner;

public class PartidoTenis {
    
    private static String player1, player2;
    private static Scanner sc;
    
    public static void main(String[] args) {
        
        sc = new Scanner(System.in);
                            
        System.out.println("Empieza el partido.");
        System.out.println("========================");
        
        System.out.print("Nombre de jugador 1: ");
        player1 = sc.nextLine();
        
        System.out.print("Nombre de jugador 2: ");
        player2 = sc.nextLine();
        
        Partido pj = new Partido(player1, player2);
        
        pj.comenzarPartido();
        pj.estadisticas();
        
    }
    
}
