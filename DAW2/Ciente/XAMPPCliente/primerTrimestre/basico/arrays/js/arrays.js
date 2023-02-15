onload = iniciar;

//Texto - Variable de ambito global
let texto = "";

let datoUsuario;
let salida;
let numero;

function iniciar() {
    //Recuperar objetos del DOM (elementos o nodos)
    datoUsuario = document.getElementById('valores');
    salida = document.getElementById('salida');
    numero = document.getElementById('numero');
}

function arraysBasico() {

    let listaNumeros = datoUsuario.value.split(' ');

    console.log(listaNumeros);

    listaNumeros[10] = "daw";

    listaNumeros.forEach(suma);

    //Imprime todos los elementos inclusive si hay undefined. 
    for (num of listaNumeros) {
        texto += "a" + num + '<br>';
    }

    salida.innerHTML = texto;
}

//Imprime a traves de for each, se salta los undefined.
function suma(value) {
    texto += (parseInt(value) + 2) + "<br>";
}

//Imprime string.
function arrayToString() {
    salida.innerHTML = datoUsuario.value.split(" ").toString();
}

//Join separa los elementos por lo introducido.
function arrayJoin() {
    salida.innerHTML = datoUsuario.value.split(" ").join(numero.value);
}

//Pop siempre quita el último.
function arrayPop() {
    let lista = datoUsuario.value.split(" ");
    lista.pop();
    salida.innerHTML = lista.join("-");
}

function arrayPush() {
    let lista = datoUsuario.value.split(" ");
    lista.push(numero.value);
    salida.innerHTML = lista.join("-");
}

function ordenarNormal() {
    let lista = datoUsuario.value.split(" ");
    lista.sort();
    salida.innerHTML = lista.join("-");
}

function ordenarReverse() {
    let lista = datoUsuario.value.split(" ");
    //Reserve solo le da la vuelta al array, no ordena. 
    lista.sort().reverse();
    salida.innerHTML = lista.join("-");
}

function ordenarNumericamente() {
    let lista = datoUsuario.value.split(" ");
    lista.sort(ordenNum);
    //Esto es lo msimo que llamar a la función => 
    //lista.sort(function (a, b) { return a - b });
    //lista.sort((a, b) => { return a - b });
    salida.innerHTML = lista.join("-");
}

function ordenNum(a, b) {
    return a - b;
    //Lo devuelve al revés => return b - a;
}

function arrayForEach() {
    let lista = datoUsuario.value.split(" ");
    console.log(lista);
    lista.forEach(pasaAEntero);
}

function pasaAEntero(value, index, array) {
    salida.innerHTML += value + "-" + index + ":";
    //Convertir de string a integer.
    // if (value >= 100) {
    //     array[index] = parseInt(value);
    // }
    return parseInt(value);
}

function arrayMap() {
    const lista = datoUsuario.value.split(" ");
    const nuevaLista = lista.map(pasaAEntero);
    console.log(nuevaLista);
}