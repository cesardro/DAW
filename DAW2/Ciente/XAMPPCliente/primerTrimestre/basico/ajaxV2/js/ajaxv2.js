onload = principal;

function principal() {
    document.getElementById("pedirDatos").setAttribute("onclick", "llamadaServidor()");
}

function llamadaServidor() {
    //Configuración y objetos
    let parrafo = document.getElementById("salida");

    let xmlhttp = new XMLHttpRequest();

    //Código para tratar la respuesta
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            //Transformamos de JSON.
            let n = JSON.parse(this.responseText);
            parrafo.innerHTML = n;
        }
    };

    //Código para hacer la petición al servidor
    xmlhttp.open("GET", "dimeN.py", true);
    //Ejecutar la petición al servidor
    xmlhttp.send();
}
