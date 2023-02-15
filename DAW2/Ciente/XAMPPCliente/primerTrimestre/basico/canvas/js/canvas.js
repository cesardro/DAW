onload = principal;

let ctx;

function principal() {
    let canvas = document.getElementById("myCanvas");
    ctx = canvas.getContext("2d");
    console.log(canvas.width);
    console.log(canvas.height);

    ctx.fillStyle = "#FF0000";
    ctx.fillRect(0, 0, canvas.height / 2, canvas.height / 2);

    ctx.fillStyle = "#00FF00";
    ctx.fillRect(canvas.height / 2, canvas.height / 2, canvas.height / 2, canvas.height / 2);
}

function dibujaLinea() {
    let canvas = document.getElementById("myCanvas2");
    ctx = canvas.getContext("2d");
    let x = document.getElementById("coordx").value;
    let y = document.getElementById("coordy").value;
    let ancho = document.getElementById("ancho").value;
    let color = document.getElementById("color").value;

    ctx.beginPath();

    ctx.lineWidth = ancho;
    ctx.strokeStyle = color;

    ctx.moveTo(canvas.height / 2, canvas.height / 2);
    //ctx.lineTo(x, y);
    ctx.lineTo(100, 100);
    ctx.lineTo(0, 100);
    ctx.fill();
    ctx.stroke();
}

function dibujaCirculo() {
    let canvas = document.getElementById("myCanvas3");
    ctx = canvas.getContext("2d");
    let x = document.getElementById("x").value;
    let y = document.getElementById("y").value;
    let ancho = document.getElementById("radio").value;
    let color = document.getElementById("color2").value;

    ctx.beginPath();
    ctx.strokeStyle = color;
    ctx.arc(x, y, ancho, 0, 2 * Math.PI);
    ctx.stroke();
}
