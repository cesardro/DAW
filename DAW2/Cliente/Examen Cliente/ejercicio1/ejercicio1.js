$(principal);

function principal() {
    $("body").append($("<h2>"));
    $("h2").text("Ventas por mes");

    $("body").append($("<h4>"));
    $("h4").text("Informe semestral");

    $("body").append("<table></table");

    let cabeza = "<thead><tr><td>Mes</td><td>Ventas</td></tr></thead>";
    $("table").append(cabeza);

    let tabla = {
        id: "cuerpoTabla"
    };
    let add = $("<tbody>", tabla);
    $("table").append(add);

    let meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"];
    let ventas = ["10.325$", "9.188$", "11.987$", "7.625$", "12.967$", "11.134$"];
    for (let index = 0; index < meses.length; index++) {
        $("#cuerpoTabla").append("<tr><td>" + meses[index] + "</td><td>" + ventas[index] + "</td></tr>");
    }
}
