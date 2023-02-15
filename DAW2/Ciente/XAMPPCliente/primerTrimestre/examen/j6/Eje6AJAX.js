function compruebaPrimo() {
    let salida = document.getElementById("salida");

    let num = document.getElementById("num").value;

    if (0 < num && num < 100) {
        //Crear el objeto XMLHttpRequest para acceder al servidor
        let xmlhttp = new XMLHttpRequest();

        //Registrar la función que se ejecuta con la respuesta del servidor
        xmlhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                let queSoy = JSON.parse(this.responseText);
                salida.innerHTML = queSoy;
            }
        };

        //Construir la petición al servidor
        xmlhttp.open("GET", "primos.py?numero=" + num, true);
        //Ejecutar la petición al servidor
        xmlhttp.send();
    }
}
