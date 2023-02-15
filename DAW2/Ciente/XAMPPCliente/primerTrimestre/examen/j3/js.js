function sonPares(listaNumeros) {
    for (let x = 0; x < listaNumeros.length; x++) {
        if (listaNumeros[x] % 2 != 0) {
            return false;
        } else {
            return true;
        }
    }
}
