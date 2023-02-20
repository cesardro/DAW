function meteEnLista() {
    //Recuperamos los elementos padre.
    let introducir = document.getElementById('nuevo');
    let tabla = document.getElementById('table');

    //Creamos los nuevos elemenos tr y td.
    let tr = document.createElement('tr');
    let td1 = document.createElement('td');
    let td2 = document.createElement('td');

    //Creamos los elementos que van a ser introducidos al tr y td.
    let texto = document.createTextNode(introducir.value);
    let btnBorrar = document.createElement('button');

    //Introducimos contenido al botón.
    btnBorrar.textContent = 'Borrar';

    //Agregamos los elementos creados: (nodeText > td) + (button > td) > tr > table
    td1.appendChild(texto);
    td2.appendChild(btnBorrar);
    tr.appendChild(td1);
    tr.appendChild(td2);
    tabla.appendChild(tr);
}