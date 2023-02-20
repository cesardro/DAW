onload = principal;

function principal() {
    document.getElementById("enviar").setAttribute("onclick", "llamadaAjax()");
}

function llamadaAjax() {
    let numero = document.getElementById("numero").value;

    //Crear el objeto XMLHttpRequest para acceder al servidor
    let xmlhttp = new XMLHttpRequest();

    //Registrar la función que se ejecuta con la respuesta del servidor
    xmlhttp.onreadystatechange = function () {
        //Evaluar la respuesta del servidor
        if (this.readyState == 4 && this.status == 200) {
            //Tratar los datos enviados por el servidor
            document.getElementById("salida").innerHTML = this.responseText;
        }
    };

    //Construir la petición al servidor
    xmlhttp.open("GET", "dimeNumero.py?num=" + numero, true);

    //Ejecutar la petición al servidor
    xmlhttp.send();
}
