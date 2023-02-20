onload = principal;

function principal() {
    document.getElementById("pedirDatos").setAttribute("onclick", "llamadaServidor()");
}

function llamadaServidor() {
    //Configuración y objetos
    let parrafo = document.getElementById("salida");

    let numero1 = document.getElementById("entrada1").value;
    let numero2 = document.getElementById("entrada2").value;

    let xmlhttp = new XMLHttpRequest();

    //Código para tratar la respuesta
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            if (0 < numero1 < numero2 < 10) {
                //Transformamos de JSON.
                let listaN = JSON.parse(this.responseText);
                let lista = "<ul>";
                for (n of listaN) {
                    lista += "<li>" + n + "</li>";
                }
                lista += "</ul>";
                parrafo.innerHTML = lista;
            } else {
                parrafo.innerHTML = "No es válido";
            }
        }
    };

    //Código para hacer la petición al servidor
    xmlhttp.open("GET", "dimeF.py?num1=" + numero1 + "&num2=" + numero2, true);
    //Ejecutar la petición al servidor
    xmlhttp.send();
}
