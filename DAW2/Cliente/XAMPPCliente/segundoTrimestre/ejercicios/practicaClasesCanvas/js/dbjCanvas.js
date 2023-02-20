class dbjCanvas {
    static dibujaRect(cnv, rectangulo) {
        let ctx = cnv.getContext("2d");
        ctx.fillStyle = "#FFFFFF";
        ctx.fillRect(0, 0, 400, 600);
        ctx.stroke();

        //Pintar el texto.
        ctx.font = "20px Arial";
        ctx.fillStyle = "black";
        ctx.fillText("Alto de: " + rectangulo.alto, 100, 40);
        ctx.fillText("Ancho de: " + rectangulo.ancho, 100, 70);
        ctx.fillText("Área de: " + rectangulo.alto * rectangulo.ancho, 100, 100);
        ctx.fillText("Perímetro de: " + (rectangulo.alto * 2 + rectangulo.ancho * 2), 100, 130);
        ctx.stroke();

        //Pintar el rectangulo.
        ctx.fillStyle = "green";
        let anchura = rectangulo.ancho / 2;
        let altura = rectangulo.alto / 2;
        ctx.fillRect(cnv.width / 2 - anchura, cnv.height / 2 - altura / 2, rectangulo.ancho, rectangulo.alto);
        ctx.stroke();
    }
}
