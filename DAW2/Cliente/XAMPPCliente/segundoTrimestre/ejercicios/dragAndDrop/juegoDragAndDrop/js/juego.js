$(principal);

function principal() {
    const t = $("#tablero");

    const letras = "turi";

    for (let i = 0; i < letras.length; i++) {
        t.append(
            "<span id='arrastrable" + i + "' draggable='true' ondragend='arrastrando(event)'>" + letras[i] + "</span>"
        );
    }
    comprobar();
}

function arrastrando(event) {
    $("#tablero").append($("#" + event.target.id));
    event.dataTransfer.clearData();
    comprobar();
}

function comprobar() {
    let bandera = true;
    let palabra = $("#tablero").text();
    for (let i = 1; i < palabra.length; i++) {
        if (palabra[i] < palabra[i - 1] && bandera) {
            bandera = false;
        }
    }

    if (bandera) {
        $("#tablero").css("color", "green");
    } else {
        $("#tablero").css("color", "red");
    }
}
