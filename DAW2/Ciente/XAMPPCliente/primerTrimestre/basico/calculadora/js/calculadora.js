onload = principal;

class Calcula {
    constructor() {
        this.operando1 = 0;
        this.operando2 = 0;
        this.operacion = 0; // 1 -> Suma, 2 -> Resta, 3 -> Multiplicación, 4 -> División
    }
    completaOper1(n) {
        this.operando1 = this.operando1 * 10 + n;
    }
    completaOper2(n) {
        this.operando2 = this.operando2 * 10 + n;
    }
    igual() {
        switch (this.operacion) {
            case 1:
                return parseFloat(cal.suma()).toFixed(2);
            case 2:
                return parseFloat(cal.resta()).toFixed(2);
            case 3:
                return parseFloat(cal.multiplicacion()).toFixed(2);
            case 4:
                return parseFloat(cal.division()).toFixed(2);
            default:
                return -1;
        }
    }
    suma() {
        return this.operando1 + this.operando2;
    }
    resta() {
        return this.operando1 - this.operando2;
    }
    multiplicacion() {
        return this.operando1 * this.operando2;
    }
    division() {
        if (this.operando2 == 0) {
            return "Division por 0";
        }
        return this.operando1 / this.operando2;
    }
}

let listaBotones;
let simboloBotones = [7, 8, 9, "'+'", 4, 5, 6, "'-'", 1, 2, 3, "'*'", "','", 0, "'='", "'/'"];

function principal() {
    dibujaCalculadora();
}

function dibujaCalculadora() {

    let calculadora = document.getElementById("calculadoraId");

    listaBotones = document.getElementById("calculadoraId").childNodes;
    for (let index = 1; index < 17; index++) {
        let texto = document.createElement("p");
        texto.setAttribute("class", "boton");
        texto.setAttribute("onclick", "pulsado(" + simboloBotones[index - 1] + ")");
        calculadora.appendChild(texto);
        listaBotones[index].innerHTML = simboloBotones[index - 1];
    }
}

let stage = 0;
let cal = new Calcula();
let yaTengoComa = false;

/*
stage 0 -> Calculadora sin empezar.
stage 1 -> Primer numero introducido.
stage 2 -> Operador introducido.
stage 3 -> Segundo numero introducido.
stage 4 -> Presiona igual. 
*/

function pulsado(n) {
    if (stage == 0 && n != '+' && n != '-' && n != '*' && n != '/' && n != '=' && n != ',') {
        stage = 1;
        cal.operando1 = n;
        document.getElementById("informacion").innerHTML = n;
    } else if (stage == 1) {
        if (n == '+' || n == '-' || n == '*' || n == '/') {
            stage = 2;
            numEntero = 10;
            transformaComa = 10;
            queSoy(n);
            document.getElementById("informacion").innerHTML = document.getElementById("informacion").innerHTML + n;
        } else if (n == ',' || yaTengoComa == true) {
            ponemosComa(n);
        } else if(n != '='){
            cal.completaOper1(n);
            document.getElementById("informacion").innerHTML = document.getElementById("informacion").innerHTML + n;
        }
    } else if (stage == 2 && (n != '+' && n != '-' && n != '*' && n != '/' && n != '=' && n != ',')) {
        stage = 3;
        yaTengoComa = false;
        cal.operando2 = n;
        document.getElementById("informacion").innerHTML = document.getElementById("informacion").innerHTML + n;
    } else if (stage == 3) {
        if (n == '=') {
            stage = 4;
            document.getElementById("informacion").innerHTML = document.getElementById("informacion").innerHTML + n;
        } else if (n == ',' || yaTengoComa == true) {
            ponemosComa(n);
        } else if (n != '+' && n != '-' && n != '*' && n != '/') {
            cal.completaOper2(n);
            document.getElementById("informacion").innerHTML = document.getElementById("informacion").innerHTML + n;
        }
    }

    if (stage == 4) {
        document.getElementById("informacion").innerHTML = document.getElementById("informacion").innerHTML + cal.igual();
        stage = 0;
        yaTengoComa = false;
    }

}

let transformaComa = 10;

function ponemosComa(n) {

    if (yaTengoComa) {
        if (stage == 1 && n != ',') {
            cal.operando1 += n / transformaComa;
            transformaComa = transformaComa * 10;
        }
        if (stage == 3 && n != ',') {
            cal.operando2 += n / transformaComa;
            transformaComa = transformaComa * 10;
        }
    }

    if(yaTengoComa == false || n != ','){
        document.getElementById("informacion").innerHTML = document.getElementById("informacion").innerHTML + n;
    }
    yaTengoComa = true;
}

function queSoy(n) {
    if (n == '+') {
        cal.operacion = 1;
    }
    if (n == '-') {
        cal.operacion = 2;
    }
    if (n == '*') {
        cal.operacion = 3;
    }
    if (n == '/') {
        cal.operacion = 4;
    }
}