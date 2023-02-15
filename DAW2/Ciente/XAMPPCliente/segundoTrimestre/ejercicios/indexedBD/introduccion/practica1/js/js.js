let openRequest = indexedDB.open("valores", 1);

let db;

openRequest.onsuccess = function () {
    console.log("Base de datos abierta con éxito.");

    db = openRequest.result;

    let trans = db.transaction("datosFormulario", "readwrite");
    let almacen = trans.objectStore("datosFormulario");

    let numero = 300;

    let resultado = almacen.put(numero, "esto es una clave");
    let resultado1 = almacen.put("otro valor", "clave2");

    resultado.onsuccess = function () {
        console.log("Insertado con exito.");
    };
    resultado.onerror = function () {
        console.log("Error al insertar.");
    };
};

openRequest.onerror = function () {
    console.log("Base de datos abierta con ERROR.");
};

openRequest.onupgradeneeded = function (evento) {
    //Este evento se lanza si:
    //No hay base de datos o
    //la base de datos actual es de versión
    //menos que la indicada arriba.
    console.log("Lanzando el evento on upgrade needed");

    //Objecto para manejar las operaciones con la base de datos.
    let db = openRequest.result;

    //Comprobar que existe el ObjectStore datosFormulario
    //Si no existe, se crea.
    if (!db.objectStoreNames.contains("datosFormulario")) {
        db.createObjectStore("datosFormulario");
    }
};

function guardar() {
    //Abrimos una transacción.
    let trans = db.transaction("datosFormulario", "readwrite");

    //Recuperamos el objectStore.
    let almacenValores = trans.objectStore("datosFormulario");

    //Recuperamos el valor del input.
    let v1 = $("#valor1").val();

    //Insertamos en la base de datos local.
    let res = almacenValores.put(v1, "valor1");

    res.onerror = function () {
        error();
    };
    res.onsuccess = function () {
        exito();
    };
}

function error() {
    console.log("Error al insertar en el almacen.");
}

function exito() {
    console.log("Exito al insertar en el almacen.");
}

function listar() {
    //Abrimos una transacción.
    let trans = db.transaction("datosFormulario", "readwrite");
    let almacenValores = trans.objectStore("datosFormulario");

    //Abirmos un cursor.
    let request = almacenValores.openCursor();

    //Si el cursor se abre con exito.
    request.onsuccess = function () {
        //Recuperamos un objeto cursor que apunta a la primera fila.
        let cursor = request.result;

        //El cursor es false si apunta a la "nada".
        //Pero si apunta a algun sitio, se ejecuta.
        if (cursor) {
            let key = cursor.key; //Clave del libro (campo ID)
            let value = cursor.value; //Valor del libro
            $("#datos").append("<tr><td>" + key + "</td><td>" + value + "</td></tr>");
            cursor.continue();
        } else {
            console.log("No hay más libros.");
        }
    };

    //Esta es una forma de obtener las keys y values para meterlos en una tabla
    //Pero puede petar si la base de datos es muy grande.
    // let arrayClaves = almacenValores.getAllKeys();
    // arrayClaves.onsuccess = function () {
    //     for (let ac of arrayClaves.result) {
    //         let req = almacenValores.get(ac);
    //         req.onsuccess = function () {
    //             $("#datos").append("<tr><td>" + ac + "</td><td>" + req.result + "</td></tr>");
    //         };
    //     }
    // };
}

// console.log("Lanzando el evento on upgrade needed.");
// let db = openRequest.result;
// switch (evento.oldVersion) {
//     case 0:
//         console.log("No hay base de datos. ");
//         break;
//     case 1:
//         console.log("Base de datos en version 1");
//         break;
//     default:
//         console.log("Version: " + evento.oldVersion);
//         break;
// }
