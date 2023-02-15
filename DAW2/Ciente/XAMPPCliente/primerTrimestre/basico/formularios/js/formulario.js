let longNomb;
let edadNum;

function campoNoVacio() {
    // if (document.getElementById("nombre").value.lenght == 0) {
    //     return false;
    // }
    // return true;
    // let resultado = document.getElementById("nombre").value.length == 0 ? false : true;
    // return resultado;
    let nom = document.getElementById("nombre").value;
    let edad = document.getElementById("edad").value;

    longNomb = nom.length;

    if (longNomb == 0) {
        return false;
    }

    let patron = /\b[0-9]+\b/;
    if (!patron.test(edad)) {
        document.getElementById("edad").style.backgroundColor = "red";
        return false;
    }

    return true;
}
