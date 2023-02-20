let openRequest = indexedDB.open("objetos", 1);

let db;

openRequest.onsuccess = function () {
    db = openRequest.result;
};

openRequest.onerror = function () {
    console.log("Error al acceder a la base de datos");
};

openRequest.onupgradeneeded = function () {
    let db = openRequest.result;

    if (!db.objectStoreNames.contains("almacenObjetos")) {
        db.createObjectStore("almacenObjetos", {keyPath: "id"});
    }
};

function guardar() {
    let trns = db.transaction("almacenObjetos", "readwrite");

    //recuperamos el objectStore
    let almacenValores = trns.objectStore("almacenObjetos");

    //Recuperamos el valor del input
    let miObjeto = {
        id: $("#valor1").val(),
        val2: $("#valor2").val(),
        val3: $("#valor3").val()
    };

    //insertamos en la base de datos
    let res = almacenValores.put(miObjeto);

    res.onerror = function () {
        error();
    };
    res.onsuccess = function () {
        exito();
    };
}

function error() {
    console.log("error al insertar");
}

function exito() {
    console.log("exito al insertar");
}

function listar() {
    let trns = db.transaction("almacenObjetos");
    let almacenValores = trns.objectStore("almacenObjetos");

    //abrimos un cursor
    let request = almacenValores.openCursor();

    //si el cursor se abre con exito
    request.onsuccess = function () {
        //recuperamos un objeto cursor que apunta a la primera fila
        let cursor = request.result;

        //el cursor es false si apunta a "nada"
        if (cursor) {
            let clave = cursor.key; //recuperar la clave
            let valor = cursor.value; //recuperar el valor
            let salida = "";
            console.log(valor);
            for (v in valor) {
                salida += valor[v] + ":";
            }
            $("#datos").append("<tr><td>" + clave + "</td><td>" + salida + "</td></tr>");
            cursor.continue();
        } else {
            console.log("No hay más resultados");
        }
    };
}

// ● IDBKeyRange.lowerBound(lower, [open])
// significa: ≥ lower (o > lower si open es true)
// ● IDBKeyRange.upperBound(upper, [open])
// significa: ≤ upper (o < upper si open es true)
// ● IDBKeyRange.bound(lower, upper,
// [lowerOpen], [upperOpen]) significa: entre
// lower y upper. Si el indicador “open” es true, la
// clave correspondiente no es incluida en el rango.
// ● IDBKeyRange.only(key) – es un rango
// compuesto solamente por una clave key, es
// raramente usado.

// ● store.get(query) – busca el primer valor, por
// clave o por rango.
// ● store.getAll([query], [count]) – busca
// todos los valores, limitado a la cantidad count si
// esta se especifica.
// ● store.getKey(query) – busca la primera clave
// que satisface la consulta, usualmente un rango.
// ● store.getAllKeys([query], [count]) – busca
// todas las claves que satisfacen la consulta,
// usualmente un rango, hasta la cantidad count si es
// suministrada.
// ● store.count([query]) – obtiene la cantidad de
// claves que satisfacen la consulta, usualmente un
// rango.

// objectStore.createIndex(name, keyPath, [options]);
// ● name – nombre del índice,
// ● keyPath – ruta al campo del objeto que el índice debe
// seguir (vamos a buscar por ese campo),
// ● option – un objeto opcional con las propiedades:
// ○ unique – si es true, un valor no podrá repetirse en el
// índice. Solamente puede haber un único objeto en el
// almacén con un valor dado de su keyPath. El índice
// forzará esto generando un error si intentamos
// agregar un duplicado.
// ○ multiEntry – solo se usa si el valor en keyPath es
// un array. En ese caso, de manera predeterminada, el
// índice tratará el array completo como clave. Pero si
// multiEntry es true, entonces el índice mantendrá
// una lista de objetos almacenados para cada valor en
// ese array. Así los miembros del array se vuelven
// claves de ese índice.

// objectStore.delete(id); //por clave

// objectStore.clear(); // todo
