function validaTexto() {
    let texto = document.getElementById("texto").value;

    let textoNum = texto.length;
    if (8 <= textoNum && textoNum <= 10) {
        if (texto.substring(0, 3) == "123") {
            return true;
        } else {
            alert("No empieza por 123.");
            return false;
        }
    } else {
        alert("Cadena menor a 8 o mayor a 10 caracteres.");
        return false;
    }
}
