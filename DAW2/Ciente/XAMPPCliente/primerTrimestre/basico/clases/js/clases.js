import Persona from "./persona.js"

const persona1 = new Persona("Jose", "Garcia", "24");
const persona2 = new Persona("Ana", "Garcia", "24");

console.log(persona1.nombreCompleto() + " - " + persona2.nombreCompleto());