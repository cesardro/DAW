//Clase empleado que hereda de herencia, tiene un campo salario y un método infoEmpleado.
//Más la información de persona.

class Empleado extends Persona {
    constructor(nom, apell, ed, sal) {
        super(nom, apell, ed);
        this._salario = sal;
    }
    //==================================
    get salario() {
        return this._salario;
    }
    set salario(n) {
        this._salario = n;
    }
    //==================================
    infoEmpleado() {
        return this.infoPersona() + ", " + this._salario;
    }
}
