onload = principal;

function principal() {
    let ran = Math.floor(Math.random() * 10) + 1;
    let num = prompt("Adivina el número (1-10): ");
    while (ran != num) {
        num = prompt("Adivina el número (1-10): ");
    }
    alert("Ganaste, el número era: " + ran);
}