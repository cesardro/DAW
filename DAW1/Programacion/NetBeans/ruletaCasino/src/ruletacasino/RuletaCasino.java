package ruletacasino;

import java.util.Scanner;

public class RuletaCasino {
    
    
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);
        StringBuffer apuesta;
        
        Character[] listaNumeroRuleta = {'V','R','N','R','N','R','N','R',
                                         'N','R','N','N','R','N','R','N',
                                         'R','N','R','R','N','R','N','R',
                                         'N','R','N','R','N','N','R','N',
                                         'R','N','R','N','R'};
        
        System.out.print("Introduce el número que desea apostar: ");
        apuesta = new StringBuffer(sc.nextLine());
        
        
        boolean numTexto = true;
        for (int i = 0; i < apuesta.length(); i++) {
            //Si(no esUnDigito(apuesta[i])))...
            if(!Character.isDigit(apuesta.charAt(i))){
                numTexto = false;
            }
        }
        if(numTexto){
            System.out.println("El número apostado es: "+apuesta);
            Integer numApostado = Integer.valueOf(apuesta.toString());
            if(numApostado < 0 || numApostado > 36){
                System.out.println("La es incorrecta.");
            }else{
                System.out.println("No va más");
            }
            
            int min = 0, max = 36;
            int bola = (int) (Math.random()*(max));
            
            System.out.println("La bola se quedó en: "+bola);
            
            StringBuffer salida = new StringBuffer("Ha salido "+bola+", ");
            
            switch(listaNumeroRuleta[bola]){
                case 'V':
                    salida = salida.append("Gana la banca.");
                    break;
                case 'R':
                    salida = salida.append("rojo,");
                    break;
                case 'N':
                    salida = salida.append("negro,");
                    break;
            }
            
            if(bola!=0){
                if(bola%2==0){
                    salida.append(" par");
                }else{
                    salida.append(" impar");
                }
                if(bola>18){
                    salida.append(" y falta.");
                }else{
                    salida.append(" y pasa.");
                }
            }
            
            System.out.println(salida);
            
            if(numApostado==bola){
                    System.out.println("Eres rico.");
                }else{
                    System.out.println("Se siente.");
                }
            
        }else{
            System.out.println("Error");
        }
        
    }
    
}
