let n = prompt("Ingresa número: ")

if (n > 0 && n < 11) {
    console.log("Tabla del ", n);
    for (let index = 0; index <= 10; index++) {
        console.log(n, " x " + index + " = " + index * n);
    }
} else {
    console.log("Número no válido.")
}