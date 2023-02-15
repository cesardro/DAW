package agenda;
public class Direccion {
    
    private String tipoCalle;
    private String nomCalle;
    private String portal;
    private String situacion;
    private String cp;
    private String localidad;
    private String provincia;
    private String pais;

    //******************** Constructor ********************//
    public Direccion(String tipoCalle, String nomCalle, String portal, String situacion, String cp, String localidad, String provincia, String pais) {
        this.tipoCalle = tipoCalle;
        this.nomCalle = nomCalle;
        this.portal = portal;
        this.situacion = situacion;
        this.cp = cp;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
    }

    //******************** get & set TipoCalle ********************//
    public String getTipoCalle() {
        return tipoCalle;
    }

    public void setTipoCalle(String tipoCalle) {
        this.tipoCalle = tipoCalle;
    }

    //******************** get & set NomCalle ********************//
    public String getNomCalle() {
        return nomCalle;
    }

    public void setNomCalle(String nomCalle) {
        this.nomCalle = nomCalle;
    }

    //******************** get & set Portal ********************//
    public String getPortal() {
        return portal;
    }

    public void setPortal(String portal) {
        this.portal = portal;
    }

    //******************** get & set Situacion ********************//
    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    //******************** get & set CP ********************//
    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    //******************** get & set Localidad ********************//
    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    //******************** get & set Provincia ********************//
    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    //******************** get & set Pais ********************//
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    //******************** toString ********************//
    @Override
    public String toString() {
        return "\n\t Direccion:\n" + "\t Tipo de calle = " + tipoCalle + "\n\t Nombre de calle = " + nomCalle + "\n\t Portal = " + portal + "\n\t Situación = " + situacion + "\n\t Código Postal = " + cp + "\n\t Localidad = " + localidad + "\n\t Provincia = " + provincia + "\n\t País = " + pais;
    }
    
}
