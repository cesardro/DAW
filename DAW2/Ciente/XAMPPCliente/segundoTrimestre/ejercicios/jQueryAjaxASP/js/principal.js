// $("#btn").click(principal);

// function principal() {
//     $.post("parrafo.html", {}, respuesta);
// }

// function respuesta(data, status) {
//     $("#salida").append(data);
// }

// //--------------------------------

// $("#btn2").click(llamadaPython);

// function llamadaPython() {
//     $.post("py/prueba.py", {numero: $("#numero").val(), texto: "saludo"}, respuesta);
// }

//Almacenamos los cuatro elementos input
let el = $("#equipoLocal");
let ev = $("#equipoVisitante");
let gl = $("#golesLocal");
let gv = $("#golesVisitante");

//Asociamos al boton btn la funcion registraPartido.
$("#btnER").click(registraPartido);
$("#btnMR").click(modificaPartido);
$("#btnDL").click(borraPartido);
$("#btnLF").click(limpiaFormulario);

let idTablaMod;

//Carga de datos incial, directo de la BD a la tabla HTML.
function cargaInicial() {
    $.post("py/datosPartidos.py", {}, inciarTabla);
}

function inciarTabla(data, status) {
    if (status == "success") {
        //Introduce los datos que vienen en un JSON en la tabla.
        let datosPartidos = $.parseJSON(data);
        $("#tablaCuerpo").empty();
        for (dp of datosPartidos) {
            crearFila(dp.IDTabla, dp.EquipoLocal, dp.EquipoVisitante, dp.GolesLocal, dp.GolesVisitante);
        }
    } else {
        alert("Error al recuperar los partidos.");
    }
}

//Guardar un partido en la BD del servidor y añadir a la tabla.
function registraPartido() {
    if (validarDatos) {
        $.post(
            "py/inserta.py",
            {
                EquipoLocal: el.val(),
                EquipoVisitante: ev.val(),
                GolesLocal: gl.val(),
                GolesVisitante: gv.val()
            },
            respuesta
        );
    } else {
        alert("Error en datos.");
    }
}

function respuesta(data, status) {
    if (status == "success") {
        let ultimoId = $.parseJSON(data);
        crearFila(ultimoId[0][0], el.val(), ev.val(), gl.val(), gv.val());
    }
}

//Auxiliar que crea una fila en la tabla HTML para el usuario.
function crearFila(idtabla, elp, evp, glp, gvp) {
    $("#tablaCuerpo").append(
        `<tr ondblclick="rellenaFormulario(${idtabla})"><td>${elp}</td><td>${evp}</td><td>${glp}</td><td>${gvp}</td></tr>`
    );
}

function validarDatos() {
    return true;
}

//Llamada a la carga inicial de datos cuando se carga la aplicación web.
cargaInicial();

//Accion asociada al doble click de cada fila.
function rellenaFormulario(idTabla) {
    idTablaMod = idTabla;
    let celda = $(this.event.target).parent().children().first();
    el.val(celda.html());
    ev.val(celda.next().html());
    gl.val(celda.next().next().html());
    gv.val(celda.next().next().next().html());

    $("#btnER").prop("disabled", true);
    $("#btnMR").prop("disabled", false);
    $("#btnDL").prop("disabled", false);
}

//Función que modifica los datos de una fila en la base de datos y en la tabla HTML.
function modificaPartido() {
    $.post(
        "py/modificarDatos.py",
        {
            EquipoLocal: el.val(),
            EquipoVisitante: ev.val(),
            GolesLocal: gl.val(),
            GolesVisitante: gv.val(),
            ID: idTablaMod
        },
        comprobarCambio
    );
}

//Función que borra los datos de una fila en la base de datos y en la tabla HTML.
function borraPartido() {
    console.log(idTablaMod);
    $.post(
        "py/borrarFila.py",
        {
            ID: idTablaMod
        },
        comprobarCambio
    );
}

function comprobarCambio(data, status) {
    if (status == "success") {
        alert("Cambios modificados.");
        cargaInicial();
    }
}

//Función que limpia los datos en el formulario.
function limpiaFormulario() {
    el.val("");
    ev.val("");
    gl.val("");
    gv.val("");

    $("#btnER").prop("disabled", false);
    $("#btnMR").prop("disabled", true);
    $("#btnDL").prop("disabled", true);
}
