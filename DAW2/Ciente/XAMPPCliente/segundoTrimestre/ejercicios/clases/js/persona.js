class Persona {
    constructor(nom, apell, ed) {
        this._nombre = nom;
        this._apellido = apell;
        this._edad = ed;
    }
    //==================================
    get nombre() {
        return this._nombre;
    }
    set nombre(n) {
        this._nombre = n;
    }
    //==================================
    get apellido() {
        return this._apellido;
    }
    set apellido(n) {
        this._apellido = n;
    }
    //==================================
    get edad() {
        return this._edad;
    }
    set edad(n) {
        this._edad = n;
    }
    //==================================
    infoPersona() {
        return this.nombre + " " + this.apellido + ", " + this.edad;
    }
}
