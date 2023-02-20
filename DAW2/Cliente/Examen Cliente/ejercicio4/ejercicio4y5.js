let openRequest = indexedDB.open("objetos", 1);
let db;

openRequest.onsuccess = function () {
    db = openRequest.result;
    listar();
};

openRequest.onerror = function () {
    console.log("Error al acceder a la base de datos");
};

openRequest.onupgradeneeded = function () {
    let db = openRequest.result;

    if (!db.objectStoreNames.contains("listaContactos")) {
        let lista = db.createObjectStore("listaContactos", {keyPath: "telefono"});
        indexlista = lista.createIndex("empresa_idx", "empresa");
    }
};

function guardar() {
    let trns = db.transaction("listaContactos", "readwrite");

    //recuperamos el objectStore
    let almacenValores = trns.objectStore("listaContactos");

    //Recuperamos el valor del input
    let miObjeto = {
        nombre: $("#nombre").val(),
        empresa: $("#empresa").val(),
        cargo: $("#cargo").val(),
        telefono: $("#telefono").val(),
        correo: $("#correo").val()
    };

    //insertamos en la base de datos
    let res = almacenValores.put(miObjeto);

    res.onerror = function () {
        error();
    };
    res.onsuccess = function () {
        exito();
        listar();
        $("#nombre").val("");
        $("#empresa").val("");
        $("#cargo").val("");
        $("#telefono").val("");
        $("#correo").val("");
    };
}

function error() {
    console.log("error al insertar");
}

function exito() {
    console.log("exito al insertar");
}

function listar() {
    let trns = db.transaction("listaContactos");
    let almacenValores = trns.objectStore("listaContactos");

    //abrimos un cursor
    let request = almacenValores.openCursor();

    $("#listado").empty();
    $("#listado").append(
        "<tr><th>Nombre</th><th>Empresa</th><th>Cargo</th><th>Telefono</th><th>Correo</th><th>Del</th></tr>"
    );

    //si el cursor se abre con exito
    request.onsuccess = function () {
        //recuperamos un objeto cursor que apunta a la primera fila
        let cursor = request.result;

        //el cursor es false si apunta a "nada"
        if (cursor) {
            let valor = cursor.value; //recuperar el valor
            let cont = 0;
            let salida = [];
            for (v in valor) {
                salida[cont] = valor[v];
                cont++;
            }
            $("#listado").append(
                '<tr id="' +
                    salida[3] +
                    '"><td>' +
                    salida[0] +
                    "</td><td>" +
                    salida[1] +
                    "</td><td>" +
                    salida[2] +
                    "</td><td>" +
                    salida[3] +
                    "</td><td>" +
                    salida[4] +
                    "</td><td><button type='button' onclick='borrado(\"" +
                    salida[3] +
                    "\")'>➡</button></td></tr>"
            );
            cursor.continue();
        } else {
            console.log("No hay más resultados");
        }
    };
}

function borrado(borradoPersona) {
    let trnsEntrada = db.transaction("listaContactos", "readwrite");
    let almacenValoresEntrada = trnsEntrada.objectStore("listaContactos");
    almacenValoresEntrada.delete(borradoPersona);
    $("#" + borradoPersona).remove();
}

function buscarEmpresa() {
    let almacenValores = db.transaction("listaContactos").objectStore("listaContactos");
    let buscarDniIndex = almacenValores.index("empresa_idx");
    let request = buscarDniIndex.getAll($("#buscarEmpresa").val());

    request.onsuccess = function () {
        if (request.result.length !== 0) {
            let cursor = request.result;
            alert("Persona encontrada: " + cursor[0].nombre + "; Puesto: " + cursor[0].cargo);
        } else {
            console.log(request.result);
            alert("Campo vacío o apellido no encontrado.");
            listar();
        }
    };
}
