onload = principal;

function principal() {
    document.getElementById("pedirDatos").setAttribute("onclick", "llamadaServidor()");
}

function llamadaServidor() {
    //Configuración y objetos
    let parrafo = document.getElementById("salida");

    let numero = document.getElementById("entrada").value;

    let xmlhttp = new XMLHttpRequest();

    //Código para tratar la respuesta
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            //Transformamos de JSON.
            let listaN = JSON.parse(this.responseText);
            let lista = "<ol>";
            for (n of listaN) {
                lista += "<li>" + n + "</li>";
            }
            lista += "</ol>";
            parrafo.innerHTML = lista;
        }
    };

    //Código para hacer la petición al servidor
    xmlhttp.open("GET", "dimeF.py?num=" + numero, true);
    //Ejecutar la petición al servidor
    xmlhttp.send();
}
