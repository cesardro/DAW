package partidotenis;

import java.util.Scanner;

public class Juego {

    private String jugador1;
    private String jugador2;

    private int juegosJ1;
    private int juegosJ2;

    Scanner sc;

    public Juego(String jugador1, String jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

        this.juegosJ1 = 0;
        this.juegosJ2 = 0;
        sc = new Scanner(System.in);
    }

    public String getJugador1() {
        return jugador1;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    public String jugando() {

        String ganadorJuego = "";
        boolean finJuego = true;
        int bola = 1;
        int res = 0;

        System.out.println("1.- " + this.jugador1 + "<-> 2-. " + this.jugador2);

        while (finJuego) {

            System.out.print("Bola " + bola + ": ");
            res = sc.nextInt();

            if (res == 1) {
                this.juegosJ1++;
            } else if (res == 2) {
                this.juegosJ2++;
            }

            if (this.juegosJ1 >= 4) {
                ganadorJuego = "p1";
                finJuego = false;
            }
            if (this.juegosJ2 >= 4) {
                ganadorJuego = "p2";
                finJuego = false;
            }
            imprimeParciales();
            bola++;
        }
        return ganadorJuego;
    }

    private void imprimeParciales() {

        String parcialJ1 = "";
        String parcialJ2 = "";

        if (this.juegosJ1 >= 4) {
            System.out.println("Juego para " + jugador1);
        } else if (this.juegosJ2 >= 4) {
            System.out.println("Juego para " + jugador2);
        } else {
            switch (this.juegosJ1) {
                case 0:
                    parcialJ1 = "Nada";
                    break;
                case 1:
                    parcialJ1 = "15";
                    break;
                case 2:
                    parcialJ1 = "30";
                    break;
                case 3:
                    parcialJ1 = "40";
                    break;
                case 4:
                    parcialJ1 = "40 Ganador";
                    break;
                default:
                    parcialJ1 = "";
                    break;
            }

            switch (this.juegosJ2) {
                case 0:
                    parcialJ2 = "Nada";
                    break;
                case 1:
                    parcialJ2 = "15";
                    break;
                case 2:
                    parcialJ2 = "30";
                    break;
                case 3:
                    parcialJ2 = "40";
                    break;
                case 4:
                    parcialJ2 = "40 Ganador";
                    break;
                default:
                    parcialJ2 = "";
                    break;
            }
            System.out.println(parcialJ1 + " - " + parcialJ2);
        }

    }
}
