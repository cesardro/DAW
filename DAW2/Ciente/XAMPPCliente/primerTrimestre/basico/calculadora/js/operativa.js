export default class Calcula {
    constructor(){
        this.operando1 = 0;
        this.operando2 = 0;
        this.operacion = 0; // 1 -> Suma, 2 -> Resta, 3 -> Multiplicación, 4 -> División
    }
    suma(){
        return this.operando1 + this.operando2;
    }
    resta(){
        return this.operando1 - this.operando2;
    }
    multiplicacion(){
        return this.operando1 * this.operando2;
    }
    division(){
        return this.operando1 / this.operando2;
    }
}