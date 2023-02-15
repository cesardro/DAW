// console.log(Date.now()); // Milisegundos

// new Date(year, monthIndex, day, hours, minutes, seconds, milliseconds)

//Milisegundos desde que naci.
// let fNac = new Date(1998, 0, 11);
// let fechaAct = Date.now();

// console.log(fechaAct - fechaNac);

//Si es una fecha o no.
// function is_date(input) {
//     if (Object.prototype.toString.call(input) === "[object Date]") return true;
//     return false;
// }

// console.log(is_date("October 13, 2014 11:13:00"));
// console.log(is_date(new Date(86400000)));
// console.log(is_date(new Date(99, 5, 24, 11, 33, 30, 0)));
// console.log(is_date([1, 2, 4, 0]));

//Fecha bonita
// let curday = function (s) {
//     let f = new Date();
//     return f.getFullYear() + s + (f.getMonth() + 1) + s + f.getDay();
// };

// console.log(curday("/"));
// console.log(curday("-"));

//Cuantos dias tiene X mes
// let getDaysInMonth = function (mm, yy) {
//     //0 Es enero, 1 es Febrero ... 11 es diciembre
//     return new Date(yy, mm, 0).getDate();
// };

// console.log(getDaysInMonth(11, 2012));
// console.log(getDaysInMonth(2, 2022));
// console.log(getDaysInMonth(9, 2022));
// console.log(getDaysInMonth(12, 2022));

//Dice la fecha en texto.
// let month_name = function (f) {
//     const options = {weekday: "long", year: "numeric", month: "long", day: "numeric"};
//     return f.toLocaleDateString("es-ES", options);
// };

// console.log(month_name(new Date("10/11/2009")));
// console.log(month_name(new Date("11/13/2014")));

//Compara las fechas
// let compare_dates = function (f1, f2) {
//     if (f1.getTime() === f2.getTime()) {
//         return "F1 es la misma que F2";
//     } else if (f1.getTime() > f2.getTime()) {
//         return "F1 es mayor que F2";
//     } else if (f1.getTime() < f2.getTime()) {
//         return "F1 es menor que F2";
//     }
// };

// console.log(compare_dates(new Date("11/14/2013 00:00"), new Date("11/14/2013 00:00")));
// console.log(compare_dates(new Date("11/14/2013 00:01"), new Date("11/14/2013 00:00")));
// console.log(compare_dates(new Date("11/14/2013 00:00"), new Date("11/14/2013 00:01")));

function resta() {
    let fecha1 = document.getElementById("fecha1").value;
    let fecha2 = document.getElementById("fecha2").value;

    fecha1 = new Date(fecha1);
    fecha2 = new Date(fecha2);

    let diferencia;

    if (fecha1 > fecha2) {
        diferencia = fecha1 - fecha2;
    } else if (fecha2 > fecha1) {
        diferencia = fecha2 - fecha1;
    }

    document.getElementById("anio").innerHTML = Math.floor(diferencia / 1000 / 60 / 60 / 24 / 30 / 12);
    document.getElementById("mes").innerHTML = Math.floor(diferencia / 1000 / 60 / 60 / 24 / 30);
    document.getElementById("dia").innerHTML = Math.floor(diferencia / 1000 / 60 / 60 / 24);
}
