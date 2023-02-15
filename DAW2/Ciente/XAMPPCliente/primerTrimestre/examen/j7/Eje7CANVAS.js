onload = principal;

function principal() {
    let canvas = document.getElementById("ajedrez");
    let ctx = canvas.getContext("2d");

    //true Blanco
    //false Negro
    let bandera = true;

    ejeX = 0;
    ejeY = 0;

    for (let x = 0; x < 8; x++) {
        for (let y = 0; y < 8; y++) {
            if (bandera) {
                ctx.fillStyle = "white";
                ctx.fillRect(ejeX, ejeY, 50, 50);
                ctx.stroke();
            } else {
                ctx.fillStyle = "black";
                ctx.fillRect(ejeX, ejeY, 50, 50);
                ctx.stroke();
            }
            ejeX = ejeX + 50;
            bandera = !bandera;
        }
        ejeY = ejeY + 50;
        ejeX = 0;
        bandera = !bandera;
    }
}
