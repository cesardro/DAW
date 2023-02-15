onload = principal;

function principal() {
    document.getElementById("siguiente").setAttribute("onclick", "llamadaServidor()");
    llamadaServidor();
}

function llamadaServidor() {
    //Configuración y objetos
    let name = document.getElementById("name");
    let date_of_birth = document.getElementById("date_of_birth");
    let address = document.getElementById("address");

    let xmlhttp = new XMLHttpRequest();

    //Código para tratar la respuesta
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let persona = JSON.parse(this.responseText);
            document.getElementById("avatar").setAttribute("src", persona.avatar);
            name.innerHTML = "Identifiación: " + persona.first_name + " " + persona.last_name;
            date_of_birth.innerHTML = "Nacimiento: " + persona.date_of_birth;
            address.innerHTML = "Ciudad: " + persona.address.city;
        }
    };

    //Código para hacer la petición al servidor
    xmlhttp.open("GET", "https://random-data-api.com/api/v2/users", true);
    xmlhttp.send();
}
