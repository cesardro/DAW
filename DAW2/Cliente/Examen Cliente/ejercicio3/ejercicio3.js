function parr(num) {
    $.get("ejer3B.py", {parr: num}, iniciarFuncion);
}

function iniciarFuncion(data, status) {
    if (status == "success") {
        $("#salida").text("");
        let datos = $.parseJSON(data);
        $("#salida").append(datos);
    } else {
        console.log("error");
    }
}
