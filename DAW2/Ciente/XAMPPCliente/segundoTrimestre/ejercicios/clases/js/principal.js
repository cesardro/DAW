let e1 = new Empleado("Juan", "Lopez Rodriguez", 43, 2000);
let e2 = new Empleado("Ana", "Rodriguez Lopez", 34, 3000);

alert(e1.infoEmpleado());
console.log(e2.infoEmpleado());

e1.nombre = "Jorge Juan";
alert(e1.infoPersona());
