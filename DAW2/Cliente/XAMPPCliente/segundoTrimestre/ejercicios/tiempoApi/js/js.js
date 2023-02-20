let linkHoy;
let datosJSON;
let diasSemana = ["Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"];
let xValues = [];

function llamadaServidor() {
    $.ajax({
        url: "https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/28161/?api_key=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJrbGV4Z2FtZXJ5dEBnbWFpbC5jb20iLCJqdGkiOiJiY2ZjNzA2My0xNWFmLTQ1NTMtOGZjYy1mZTNiNWQ0YmIyY2IiLCJpc3MiOiJBRU1FVCIsImlhdCI6MTY3NTA2MzU4MSwidXNlcklkIjoiYmNmYzcwNjMtMTVhZi00NTUzLThmY2MtZmUzYjVkNGJiMmNiIiwicm9sZSI6IiJ9.dBCHfaya1uMfcwFmny7Q-17jxP4dNa3YNcnDNARqPqw",
        success: function (data) {
            linkHoy = data.datos;
            $.ajax({
                url: linkHoy,
                success: function (datos) {
                    datosJSON = JSON.parse(datos);

                    diasDeLaSemana();

                    $("#municipio").text(datosJSON[0].nombre + ", ");
                    $("#ubicacion").text(datosJSON[0].provincia + ", España");

                    $("#maxMinHoy").text(
                        "Maxima: " +
                            datosJSON[0].prediccion.dia[0].temperatura.maxima +
                            "ºC Minima: " +
                            datosJSON[0].prediccion.dia[0].temperatura.minima +
                            "ºC"
                    );

                    iconosDeLosDias();
                    crearChart();
                }
            });
        }
    });
}

llamadaServidor();

function diasDeLaSemana() {
    for (let index = 0; index < 7; index++) {
        let date = new Date(datosJSON[0].prediccion.dia[index].fecha);
        let diaSemana = diasSemana[date.getDay()];

        if (index == 0) {
            queDiaEsHoy();
            $("#dia" + index).text("Hoy");
        } else {
            let fecha = datosJSON[0].prediccion.dia[index].fecha;
            let dia = fecha.split("-")[2].split("T")[0];
            let mes = fecha.split("-")[1].split("T")[0];
            $("#dia" + index).text(diaSemana + ", " + dia + "/" + mes);
            xValues.push(dia + "/" + mes);
        }
    }
}

function queDiaEsHoy() {
    let date = new Date(datosJSON[0].prediccion.dia[0].fecha);
    let diaSemana = diasSemana[date.getDay()];
    let fecha = datosJSON[0].prediccion.dia[0].fecha;
    let dia = fecha.split("-")[2].split("T")[0];
    let mes = fecha.split("-")[1].split("T")[0];
    $("#diaSemanaHoy").text(diaSemana + ", " + dia + "/" + mes);

    xValues.push(dia + "/" + mes);
}

function iconosDeLosDias() {
    for (let index = 0; index < 7; index++) {
        $("#iconoTemperatura" + index).text(
            "Maxima: " +
                datosJSON[0].prediccion.dia[index].temperatura.maxima +
                "ºC Minima: " +
                datosJSON[0].prediccion.dia[index].temperatura.minima +
                "ºC"
        );

        let temp = 0;

        while (datosJSON[0].prediccion.dia[index].estadoCielo[temp].value == "") {
            temp++;
        }
        $("#iconoTemperatura" + index).append(
            "<br/><br/><img src='https://www.aemet.es/imagenes_gcd/_iconos_municipios/" +
                datosJSON[0].prediccion.dia[index].estadoCielo[temp].value +
                ".png' alt='Icono día de hoy'>"
        );
        temp = 0;
    }
}

function crearChart() {
    let dataRed = [];
    let dataBlue = [];
    for (let index = 0; index < 7; index++) {
        dataRed.push(datosJSON[0].prediccion.dia[index].temperatura.maxima);
        dataBlue.push(datosJSON[0].prediccion.dia[index].temperatura.minima);
    }
    new Chart("myChart", {
        type: "line",
        data: {
            labels: xValues,
            datasets: [
                {
                    data: dataRed,
                    borderColor: "red",
                    fill: false,
                    label: "Temperatura máxima"
                },
                {
                    data: dataBlue,
                    borderColor: "blue",
                    fill: false,
                    label: "Temperatura mínima"
                }
            ]
        },
        options: {
            legend: {
                display: true,
                labels: {
                    boxWidth: 10
                }
            },
            scales: {
                xAxes: [
                    {
                        scaleLabel: {
                            display: true,
                            labelString: "Días"
                        }
                    }
                ],
                yAxes: [
                    {
                        scaleLabel: {
                            display: true,
                            labelString: "Temperaturas"
                        }
                    }
                ]
            }
        }
    });
}
