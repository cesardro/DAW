onload = principal;

function principal() {
    document.getElementById("texto1").setAttribute("onchange", "alerta(1)");
    document.getElementById("texto2").setAttribute("onchange", "alerta(2)");
}

function alerta(x) {
    let salida = document.getElementById("texto" + x).value;
    alert(salida);
}
