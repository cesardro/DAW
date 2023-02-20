// alert(document.URL);
// alert(document.doctype);
// alert(document.domain);
// alert(document.readyState);

// onload = cargaAlert;

// function cargaAlert() {
//     let cuerpo = document.body;

//     let tabla = '<table><tr>hola</td></tr><tr><td>adios</td></tr></table>';

//     let imagen = '<img src="https://static1.elcorreo.com/www/multimedia/202207/04/media/spider1.jpg" >';

//     let contenido = tabla + imagen;

//     cuerpo.innerHTML = contenido;

//     let parrafo = document.createElement("p");

//     parrafo.innerHTML = "texto";
//     parrafo.style.color = "red";

//     cuerpo.appendChild(parrafo);
// }

function crearParrafo() {
    let divParrafos = document.getElementById('parrafos');
    let parr = document.createElement('p');
    let nTexto = document.createTextNode('Hola');

    parr.appendChild(nTexto);

    divParrafos.appendChild(parr);
}

function crearEnlace() {
    //Recuperar el elemento padre del nuevo elemento.
    let divEnlaces = document.getElementById('enlaces');

    //Crear el nuevo elemento con sus atributos, valores, estilos...
    let enlace = document.createElement('a');
    enlace.setAttribute("href","http://www.google.es");
    
    //Crear texto de a.
    let nTexto = document.createTextNode("Ir a Google");
    enlace.appendChild(nTexto);

    //Añadir el elemento nuevo a su padre
    divEnlaces.appendChild(enlace);
    
    let s1 = document.createElement("br");
    divEnlaces.appendChild(s1);
}

/*
Input + buton
    tabla
texto - boton
texto - boton

(El boton no hace nada de momento)

<table>
    <tr>
        <td>Input</td><td>button</td>

    </tr>
</table>

crear nodo tr que va a tener dos hijos
td nodoTexto td button
*/