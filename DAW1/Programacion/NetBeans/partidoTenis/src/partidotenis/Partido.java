package partidotenis;

import java.util.ArrayList;

public class Partido {
    
    private String p1;
    private String p2;
    private int ganadosP1 = 0;
    private int ganadosP2 = 0;

    ArrayList<SetTenis> listaSetTenis;
    
    public Partido(String p1, String p2) {
        this.p1 = p1;
        this.p2 = p2;
        listaSetTenis = new ArrayList<SetTenis>();
    }

    //====================== get & set P1 ======================
    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    //====================== get & set P2 ======================
    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public void comenzarPartido(){
        boolean partido = true;
        int contaSet = 1;
        while(partido){
            
            System.out.println("=================");
            System.out.println("=================");
            System.out.println("Set: "+contaSet);
            
            SetTenis st = new SetTenis(this.p1, this.p2);
            
            String ganador = st.jugandoSet();
            
            listaSetTenis.add(st);
            
            switch(ganador){
                case "p1":
                    this.ganadosP1++;
                    break;
                case "p2":
                    this.ganadosP2++;
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
            
            if(this.ganadosP1>=2){
                System.out.println("Partido ganado por: "+this.p1);
                partido=false;
            }else if(this.ganadosP2>=2){
                System.out.println("Partido ganado por: "+this.p2);
                partido=false;
            }
            contaSet++;
        }
    }
    
    public void estadisticas(){
        for(SetTenis stEsta: listaSetTenis){
            System.out.println("==============================================");
            System.out.println(stEsta.getP1()+ ": " +stEsta.getJuegosGanadosP1());
            System.out.println(stEsta.getP2()+ ": " +stEsta.getJuegosGanadosP2());
        }
    }
}
