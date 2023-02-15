window.onload = principal;

function principal() {
    let n1 = prompt("Ingresa número: ");
    let n2 = prompt("Ingresa número: ");
    let n3 = prompt("Ingresa número: ");
    let n4 = prompt("Ingresa número: ");

    let numero = parseInt(n1);
    if (!Number.isInteger(numero)) {
        alert("Error numero 1");
    }
    numero = parseInt(n2);
    if (!Number.isInteger(numero)) {
        alert("Error numero 2");
    }
    numero = parseInt(n3);
    if (!Number.isInteger(numero)) {
        alert("Error numero 3");
    }
    numero = parseInt(n4);
    if (!Number.isInteger(numero)) {
        alert("Error numero 4");
    }
    alert("La media es: " + (parseInt(n1) + parseInt(n2) + parseInt(n3) + parseInt(n4)) / 4);
}
