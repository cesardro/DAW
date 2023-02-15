onload = principal;

let ancho;
let alto;

let rectangulo;
let mcnv;

function principal() {
    ancho = document.getElementById("ancho").value;
    alto = document.getElementById("alto").value;
    miCanvas = document.getElementById("miCanvas");

    rectangulo = new Rectangulo(ancho, alto);

    dbjCanvas.dibujaRect(miCanvas, rectangulo);
}

//OnChange
function dibuja() {
    ancho = document.getElementById("ancho").value;
    alto = document.getElementById("alto").value;

    rectangulo = new Rectangulo(ancho, alto);

    dbjCanvas.dibujaRect(miCanvas, rectangulo);
}
