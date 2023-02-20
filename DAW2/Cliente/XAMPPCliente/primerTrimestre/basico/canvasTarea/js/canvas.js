onload = principal;

let ctx;

function principal() {
    let canvas = document.getElementById("laberinto");
    ctx = canvas.getContext("2d");

    ctx.lineWidth = 5;

    ctx.moveTo(50, 50);
    ctx.lineTo(250, 50);
    ctx.moveTo(90, 50);
    ctx.lineTo(90, 90);
    ctx.moveTo(250, 50);
    ctx.lineTo(250, 130);
    ctx.lineTo(210, 130);
    ctx.lineTo(210, 90);
    ctx.moveTo(210, 130);
    ctx.lineTo(170, 130);
    ctx.lineTo(170, 170);
    ctx.lineTo(90, 170);
    ctx.lineTo(90, 210);
    ctx.moveTo(50, 90);
    ctx.lineTo(50, 250);
    ctx.lineTo(250, 250);
    ctx.lineTo(250, 170);
    ctx.lineTo(210, 170);
    ctx.lineTo(210, 210);
    ctx.lineTo(130, 210);
    ctx.moveTo(50, 130);
    ctx.lineTo(130, 130);
    ctx.lineTo(130, 90);
    ctx.lineTo(170, 90);
    ctx.stroke();

    canvas = document.getElementById("persona");
    ctx = canvas.getContext("2d");

    ctx.beginPath();

    ctx.lineWidth = 4;
    ctx.strokeStyle = "#93AFEC";
    ctx.arc(200, 65, 45, 0, 2 * Math.PI);

    ctx.stroke();

    ctx.beginPath();

    ctx.lineWidth = 1;
    ctx.strokeStyle = "#93AFEC";
    ctx.arc(180, 55, 10, 0, 2 * Math.PI);
    ctx.fillStyle = "#F7001A";
    ctx.fill();

    ctx.stroke();

    ctx.beginPath();

    ctx.lineWidth = 1;
    ctx.strokeStyle = "#93AFEC";
    ctx.arc(220, 55, 10, 0, 2 * Math.PI);
    ctx.fillStyle = "#F7001A";
    ctx.fill();

    ctx.stroke();

    ctx.beginPath();

    ctx.fillStyle = "#753C10";

    ctx.fillRect(140, 110, 120, 180);

    ctx.lineWidth = 3;
    ctx.strokeStyle = "#753C10";
    ctx.rect(141, 290, 35, 90);
    ctx.rect(224, 290, 35, 90);

    ctx.moveTo(260, 110);
    ctx.lineTo(330, 200);
    ctx.lineTo(305, 220);
    ctx.lineTo(250, 150);

    ctx.moveTo(140, 110);
    ctx.lineTo(70, 200);
    ctx.lineTo(95, 220);
    ctx.lineTo(150, 150);
    ctx.stroke();
}
