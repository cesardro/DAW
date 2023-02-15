const persona0 = {
    nombre: "Federico",
    apellidos: "Zapico",
    edad: 54,
    nombreCompleto: function () {
        return this.nombre + " " + this.apellidos;
    },
    fecNac: new Date("1968-05-20")
}

const persona1 = {
    nombre: "Ana",
    apellidos: "Lopez",
    edad: 29,
    nombreCompleto: function () {
        return this.nombre + " " + this.apellidos;
    },
    fecNac: new Date("1993-04-12")
}

const persona2 = {
    nombre: "Juan",
    apellidos: "Garcia",
    edad: 4,
    nombreCompleto: function () {
        return this.nombre + " " + this.apellidos;
    },
    fecNac: new Date("2018-10-10")
}

const persona3 = {
    nombre: "Antonio",
    apellidos: "Fernandez",
    edad: 45,
    nombreCompleto: function () {
        return this.nombre + " " + this.apellidos;
    },
    fecNac: new Date("1977-08-01")
}

const listaPersonas = [persona0, persona1, persona2, persona3];

function mostrarObjetos() {
    console.log(persona1.nombre);
    console.log(persona1.apellidos);
    console.log(persona1.edad);
    console.log(persona1.fecNac)
    persona1.direccion = "Calle principal...";
    console.log(persona1.nombreCompleto());

    console.log(persona2["nombre"]);
    console.log(persona2["apellidos"]);
    console.log(persona2["edad"]);
    console.log(persona2.nombreCompleto());

    console.log(listaPersonas);
}

function ordenarListaPersonas() {
    listaPersonas.sort(function (a, b) { return a.edad - b.edad });
    console.log(listaPersonas);
}

function ordenarListaPersonasPorApellidos() {
    listaPersonas.sort(ordenAlfabeticoPorApellidos);
    console.log(listaPersonas);
}

function ordenAlfabeticoPorApellidos(a, b) {
    if (a.apellidos < b.apellidos) { return -1 };
    if (a.apellidos > b.apellidos) { return 1 };
    return 0;
}

function ordenarlistaPersonasPorFechaNac() {
    listaPersonas.sort(ordenPorFecNac);
    console.log(listaPersonas);
}

function ordenPorFecNac(a, b) {
    if (a.fecNac < b.fecNac) { return -1 };
    if (a.fecNac > b.fecNac) { return 1 };
    return 0;
}

function personaMayor() {
    ordenarlistaPersonasPorFechaNac();
    document.getElementById("salida").innerHTML = listaPersonas[0].nombreCompleto();
}

function personaMenor() {
    ordenarlistaPersonasPorFechaNac();
    document.getElementById("salida").innerHTML = listaPersonas[listaPersonas.length - 1].nombreCompleto();
}