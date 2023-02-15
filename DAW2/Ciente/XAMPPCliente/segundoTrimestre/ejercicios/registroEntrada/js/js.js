let openRequest = indexedDB.open("objetos", 1);
let db, hoy, indexEntrada, indexSalida;
let fechaHora = new Date();

openRequest.onsuccess = function () {
    db = openRequest.result;
    listar();
};

openRequest.onerror = function () {
    console.log("Error al acceder a la base de datos");
};

openRequest.onupgradeneeded = function () {
    let db = openRequest.result;

    if (!db.objectStoreNames.contains("entradas")) {
        let entrada = db.createObjectStore("entradas", {keyPath: "id"});
        let salida = db.createObjectStore("salida", {keyPath: "id"});
        indexEntrada = entrada.createIndex("apellidos_idx", "val3");
        indexSalida = salida.createIndex("apellidos_idx", "val3");
    }
};

function registrar() {
    let trns = db.transaction("entradas", "readwrite");

    //recuperamos el objectStore
    let almacenValores = trns.objectStore("entradas");

    hoy = fechaHora.toLocaleTimeString("es-ES", {
        hour: "numeric",
        minute: "numeric"
    });

    //Recuperamos el valor del input
    let miObjeto = {
        id: $("#dni").val(),
        val2: $("#nombre").val(),
        val3: $("#apellidos").val(),
        val4: $("#contacto").val(),
        val5: hoy
    };

    //insertamos en la base de datos
    let res = almacenValores.put(miObjeto);

    res.onerror = function () {
        error();
    };
    res.onsuccess = function () {
        exito();
        listar();
        $("#dni").val("");
        $("#nombre").val("");
        $("#apellidos").val("");
        $("#contacto").val("");
    };
}

function error() {
    console.log("error al insertar");
}

function exito() {
    console.log("exito al insertar");
}

function listar() {
    let trns = db.transaction("entradas");
    let almacenValores = trns.objectStore("entradas");

    //abrimos un cursor
    let request = almacenValores.openCursor();

    $("#datosEntrada").empty();
    $("#datosEntrada").append(
        "<tr><th>Nombre</th><th>Apellidos</th><th>DNI</th><th>Contacto</th><th>Fecha Entrada</th><th>Salida</th></tr>"
    );

    //si el cursor se abre con exito
    request.onsuccess = function () {
        //recuperamos un objeto cursor que apunta a la primera fila
        let cursor = request.result;

        //el cursor es false si apunta a "nada"
        if (cursor) {
            let clave = cursor.key; //recuperar la clave
            let valor = cursor.value; //recuperar el valor
            let cont = 0;
            let salida = [];
            for (v in valor) {
                salida[cont] = valor[v];
                cont++;
            }
            $("#datosEntrada").append(
                "<tr id=" +
                    clave +
                    "><td>" +
                    salida[1] +
                    "</td><td>" +
                    salida[2] +
                    "</td><td>" +
                    clave +
                    "</td><td>" +
                    salida[3] +
                    "</td><td>" +
                    salida[4] +
                    "</td><td><button type='button' onclick='salePersona(\"" +
                    clave +
                    "\")'>➡</button></td></tr>"
            );
            cursor.continue();
        } else {
            console.log("No hay más resultados");
        }
    };
    listarSalida();
}

function salePersona(dniSalePersona) {
    let trnsEntrada = db.transaction("entradas", "readwrite");
    let almacenValoresEntrada = trnsEntrada.objectStore("entradas");
    let entrada = almacenValoresEntrada.get(dniSalePersona);

    entrada.onsuccess = function () {
        let datosEntrada = entrada.result;

        let trnsSalida = db.transaction("salida", "readwrite");
        let almacenValoresSalida = trnsSalida.objectStore("salida");

        hoy = fechaHora.toLocaleString("es-ES", {
            day: "2-digit",
            month: "2-digit",
            year: "numeric",
            hour: "2-digit",
            minute: "2-digit",
            second: "2-digit"
        });

        datosEntrada.val6 = hoy;

        let res = almacenValoresSalida.put(datosEntrada);
        res.onerror = function () {
            error();
        };
        res.onsuccess = function () {
            exito();
            listarSalida();
        };
    };
    almacenValoresEntrada.delete(dniSalePersona);
    $("#" + dniSalePersona).remove();
}

function listarSalida() {
    let trns = db.transaction("salida");
    let almacenValores = trns.objectStore("salida");

    //abrimos un cursor
    let request = almacenValores.openCursor();

    $("#datosSalida").empty();
    $("#datosSalida").append(
        "<tr><th>Nombre</th><th>Apellidos</th><th>DNI</th><th>Contacto</th><th>Fecha Entrada</th><th>Fecha Salida</th></tr>"
    );

    //si el cursor se abre con exito
    request.onsuccess = function () {
        //recuperamos un objeto cursor que apunta a la primera fila
        let cursor = request.result;

        //el cursor es false si apunta a "nada"
        if (cursor) {
            let clave = cursor.key; //recuperar la clave
            let valor = cursor.value; //recuperar el valor
            let cont = 0;
            let salida = [];
            for (v in valor) {
                salida[cont] = valor[v];
                cont++;
            }
            $("#datosSalida").append(
                "<tr><td>" +
                    salida[1] +
                    "</td><td>" +
                    salida[2] +
                    "</td><td>" +
                    clave +
                    "</td><td>" +
                    salida[3] +
                    "</td><td>" +
                    salida[4] +
                    "</td><td>" +
                    salida[5] +
                    "</td></tr>"
            );
            cursor.continue();
        } else {
            console.log("No hay más resultados");
        }
    };
}

function limpiar() {
    $("#dni").val("");
    $("#nombre").val("");
    $("#apellidos").val("");
    $("#contacto").val("");
}

function nuevoDia() {
    let trns = db.transaction("entradas", "readwrite").objectStore("entradas");
    trns.clear();

    trns = db.transaction("salida", "readwrite").objectStore("salida");
    trns.clear();
    listar();
}

function buscarApellidosEntrada() {
    let almacenValores = db.transaction("entradas").objectStore("entradas");
    let buscarDniIndex = almacenValores.index("apellidos_idx");
    let request = buscarDniIndex.getAll($("#apellidosBuscar").val());

    request.onsuccess = function () {
        if (request.result.length !== 0) {
            $("#datosEntrada").empty();
            $("#datosEntrada").append(
                "<tr><th>Nombre</th><th>Apellidos</th><th>DNI</th><th>Contacto</th><th>Fecha Entrada</th><th>Fecha Salida</th></tr>"
            );
            let cursor = request.result;
            for (let index = 0; index < cursor.length; index++) {
                $("#datosEntrada").append(
                    "<tr id=" +
                        cursor[index].id +
                        "><td>" +
                        cursor[index].val2 +
                        "</td><td>" +
                        cursor[index].val3 +
                        "</td><td>" +
                        cursor[index].id +
                        "</td><td>" +
                        cursor[index].val4 +
                        "</td><td>" +
                        cursor[index].val5 +
                        "</td><td><button type='button' onclick='salePersona(\"" +
                        cursor[index].id +
                        "\")'>➡</button></td></tr>"
                );
            }
            $("#datosEntrada").append("<tr><td><button type='button' onclick='listar()'>VOLVER</button></td></tr>");
        } else {
            alert("Campo vacío o apellido no encontrado.");
            listar();
        }
    };
}

function buscarApellidosSalida() {
    let almacenValores = db.transaction("salida").objectStore("salida");
    let buscarDniIndex = almacenValores.index("apellidos_idx");
    let request = buscarDniIndex.getAll($("#apellidosBuscarSalida").val());

    request.onsuccess = function () {
        if (request.result.length !== 0) {
            $("#datosSalida").empty();
            $("#datosSalida").append(
                "<tr><th>Nombre</th><th>Apellidos</th><th>DNI</th><th>Contacto</th><th>Fecha Entrada</th><th>Fecha Salida</th></tr>"
            );
            let cursor = request.result;
            for (let index = 0; index < cursor.length; index++) {
                $("#datosSalida").append(
                    "<tr><td>" +
                        cursor[index].val2 +
                        "</td><td>" +
                        cursor[index].val3 +
                        "</td><td>" +
                        cursor[index].id +
                        "</td><td>" +
                        cursor[index].val4 +
                        "</td><td>" +
                        cursor[index].val5 +
                        "</td><td>" +
                        cursor[index].val6 +
                        "</td></tr>"
                );
            }
            $("#datosSalida").append(
                "<tr><td><button type='button' onclick='listarSalida()'>VOLVER</button></td></tr>"
            );
        } else {
            alert("Campo vacío o apellido no encontrado.");
            listarSalida();
        }
    };
}

function buscarDni() {
    let almacenValores = db.transaction("entradas").objectStore("entradas");
    let entrada = almacenValores.get($("#dniBuscar").val());
    entrada.onsuccess = function () {
        if (entrada.result.length !== 0) {
            $("#datosEntrada").empty();
            $("#datosEntrada").append(
                "<tr><th>Nombre</th><th>Apellidos</th><th>DNI</th><th>Contacto</th><th>Fecha Entrada</th><th>Fecha Salida</th></tr>"
            );
            $("#datosEntrada").append(
                "<tr><td>" +
                    entrada.result.val2 +
                    "</td><td>" +
                    entrada.result.val3 +
                    "</td><td>" +
                    entrada.result.id +
                    "</td><td>" +
                    entrada.result.val4 +
                    "</td><td>" +
                    entrada.result.val5 +
                    "</td><td><button type='button' onclick='salePersona(\"" +
                    entrada.result.id +
                    "\")'>➡</button></td></tr>"
            );
            $("#datosEntrada").append("<tr><td><button type='button' onclick='listar()'>VOLVER</button></td></tr>");
        } else {
            alert("Campo vacío o DNI no encontrado.");
            listar();
        }
    };
}

function buscarDniSalida() {
    let almacenValores = db.transaction("salida").objectStore("salida");
    let entrada = almacenValores.get($("#dniBuscarSalida").val());
    entrada.onsuccess = function () {
        if (entrada.result.length !== 0) {
            $("#datosSalida").empty();
            $("#datosSalida").append(
                "<tr><th>Nombre</th><th>Apellidos</th><th>DNI</th><th>Contacto</th><th>Fecha Entrada</th><th>Fecha Salida</th></tr>"
            );
            $("#datosSalida").append(
                "<tr><td>" +
                    entrada.result.val2 +
                    "</td><td>" +
                    entrada.result.val3 +
                    "</td><td>" +
                    entrada.result.id +
                    "</td><td>" +
                    entrada.result.val4 +
                    "</td><td>" +
                    entrada.result.val5 +
                    "</td><td>" +
                    entrada.result.val6 +
                    "</td></tr>"
            );
            $("#datosSalida").append("<tr><td><button type='button' onclick='listar()'>VOLVER</button></td></tr>");
        } else {
            alert("Campo vacío o DNI no encontrado.");
            listar();
        }
    };
}
