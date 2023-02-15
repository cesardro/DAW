package partidotenis;

import java.util.ArrayList;

public class SetTenis {

    private String p1;
    private String p2;
    private int juegosGanadosP1 = 0;
    private int juegosGanadosP2 = 0;

    ArrayList<Juego> listaJuegos;

    public SetTenis(String p1, String p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.juegosGanadosP1 = 0;
        this.juegosGanadosP2 = 0;

    }

    public String jugandoSet() {
        String ganador = "";
        boolean set = true;
        String ganParcial = "";
        int contJuegos = 1;

        while (set) {

            System.out.println("=========");
            System.out.println("Juego: " + contJuegos);

            Juego j = new Juego(this.p1, this.p2);
            ganParcial = j.jugando();

            switch (ganParcial) {
                case "p1":
                    this.juegosGanadosP1++;
                    break;
                case "p2":
                    this.juegosGanadosP2++;
                    break;
                default:
                    throw new AssertionError();

            }
            if (this.juegosGanadosP1 >= 6) {
                ganador = "p1";
                set = false;
            } else if (this.juegosGanadosP2 >= 6) {
                ganador = "p2";
                set = false;
            }
            contJuegos++;
        }
        return ganador;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public int getJuegosGanadosP1() {
        return juegosGanadosP1;
    }

    public void setJuegosGanadosP1(int juegosGanadosP1) {
        this.juegosGanadosP1 = juegosGanadosP1;
    }

    public int getJuegosGanadosP2() {
        return juegosGanadosP2;
    }

    public void setJuegosGanadosP2(int juegosGanadosP2) {
        this.juegosGanadosP2 = juegosGanadosP2;
    }

    public ArrayList<Juego> getListaJuegos() {
        return listaJuegos;
    }

    public void setListaJuegos(ArrayList<Juego> listaJuegos) {
        this.listaJuegos = listaJuegos;
    }
}
