onload = principal;

function principal() {
    document.getElementById("pedirObjeto").setAttribute("onclick", "llamadaServidor()");
}

function llamadaServidor() {
    //Configuración y objetos
    let parrafo = document.getElementById("salida");

    let identificador = document.getElementById("entrada").value;

    let xmlhttp = new XMLHttpRequest();

    //Código para tratar la respuesta
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let persona = JSON.parse(this.responseText);
            if (persona != -1) {
                datos = "nombre:" + persona.nombre + "<br>";
                datos += "apellidos:" + persona.apellidos + "<br>";
                datos += "edad:" + persona.edad + "<br>";
                parrafo.innerHTML = datos;
            } else {
                parrafo.innerHTML = "Error";
            }
        }
    };

    //Código para hacer la petición al servidor
    xmlhttp.open("POST", "dimeP.py", true);
    //Ejecutar la petición al servidor
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.send("ident=" + identificador);
}
