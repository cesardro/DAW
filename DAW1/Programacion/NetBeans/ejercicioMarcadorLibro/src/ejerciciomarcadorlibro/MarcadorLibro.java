package ejerciciomarcadorlibro;

public class MarcadorLibro {
    
    private String libro;
    private int numPag;
    private int pagLeidas;

    public MarcadorLibro(String libro, int numPag, int pagLeidas) {
        this.libro = libro;
        this.numPag = numPag;
        this.pagLeidas = pagLeidas;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    public int getPagLeidas() {
        return pagLeidas;
    }

    public void setPagLeidas(int pagLeidas) {
        this.pagLeidas = pagLeidas;
    }
    
    public int dimePaginaActual(){
        return this.getPagLeidas();
    }
    
    public int paginasLeidas(int pagLeidas){
        
        if(this.getPagLeidas()+pagLeidas >= numPag){
            setPagLeidas(numPag);
            return this.getNumPag();
        }else{
            setPagLeidas(this.getPagLeidas()+pagLeidas);
            return (this.getPagLeidas()+pagLeidas);
        }  
    }
}
