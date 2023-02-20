let colorAnterior;

function arrastrando(event) {
    event.dataTransfer.setData("text/plain", event.target.id);
    //Guardamos el color del principio.
    colorAnterior = event.currentTarget.style.backgroundColor;
    //Cambiamos el color del elemento que estamos arrastrando.
    event.currentTarget.style.backgroundColor = "yellow";
}

function llego(event) {
    //Nos ayuda a aceptar la función de soltar.
    event.preventDefault();
}

function solto(event) {
    const id = event.dataTransfer.getData("text");
    const elementoArrastrado = document.getElementById(id);
    const destino = event.target;
    destino.appendChild(elementoArrastrado);
    event.dataTransfer.clearData();
}

function finArrastre(event) {
    //Fin del arrastre, volvemos al color principal.
    event.currentTarget.style.backgroundColor = colorAnterior;
}
