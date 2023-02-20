onload = principal;

let cont = 0;
let mapa = [0, 0, 0, 0, 0, 0, 0, 0, 0];

/* 1 = X - 2 = O */
let turn = 1;

let fin = false;

function principal() {
    dibujaTablero();
    document.getElementById("juegan").innerHTML = "Juegan X";
}

function dibujaTablero() {
    let tablero = document.getElementById("tableroId");

    for (let i = 0; i < 9; i++) {

        let casilla = document.createElement("div");
        casilla.setAttribute("id", "casilla");

        let imagen = document.createElement("img");
        imagen.setAttribute("src", "img/blanco.png");
        imagen.setAttribute("onclick", "pinchado(this," + i + ")");

        casilla.appendChild(imagen);
        tablero.appendChild(casilla);
    }
}

function pinchado(dibujoImg, posicion) {
    if (!fin) {
        turno(dibujoImg, posicion);
    }
}

function turno(dibujoImg, posicion) {
    if (turn == 1) {
        if (casillaOcupada(posicion)) {
            dibujoImg.setAttribute("src", "img/x.png");
            turn = 2;
            document.getElementById("juegan").innerHTML = "Juegan O";
            revisarJuego();
        }
    } else if (turn == 2) {
        if (casillaOcupada(posicion)) {
            dibujoImg.setAttribute("src", "img/o.png");
            turn = 1;
            document.getElementById("juegan").innerHTML = "Juegan X";
            revisarJuego();
        }
    } else {
        console.log("ERROR");
    }
}

/* Revisa si la casilla esta ocupada, mirando si primero en el mapa (array) está en 0 (casilla que no ha sido ocupada aún)
y que la posición sea donde está dando click para no entrar en otro if. Si todo se cumple, mete en el mapa un 1 = X o un 2 = O.
En caso de no cunplirse ninguna es porque está dando click sobre una casilla ya ocupada, y arroja un alert, y return false.*/
function casillaOcupada(posicion) {
    if (mapa[0] == 0 && posicion == 0) {
        cont++
        if (turn == 1) {
            mapa[0] = 1;
        } else if (turn == 2) {
            mapa[0] = 2;
        }
        return true;
    } else if (mapa[1] == 0 && posicion == 1) {
        cont++
        if (turn == 1) {
            mapa[1] = 1;
        } else if (turn == 2) {
            mapa[1] = 2;
        }
        return true;
    } else if (mapa[2] == 0 && posicion == 2) {
        cont++
        if (turn == 1) {
            mapa[2] = 1;
        } else if (turn == 2) {
            mapa[2] = 2;
        }
        return true;
    } else if (mapa[3] == 0 && posicion == 3) {
        cont++
        if (turn == 1) {
            mapa[3] = 1;
        } else if (turn == 2) {
            mapa[3] = 2;
        }
        return true;
    } else if (mapa[4] == 0 && posicion == 4) {
        cont++
        if (turn == 1) {
            mapa[4] = 1;
        } else if (turn == 2) {
            mapa[4] = 2;
        }
        return true;
    } else if (mapa[5] == 0 && posicion == 5) {
        cont++
        if (turn == 1) {
            mapa[5] = 1;
        } else if (turn == 2) {
            mapa[5] = 2;
        }
        return true;
    } else if (mapa[6] == 0 && posicion == 6) {
        cont++
        if (turn == 1) {
            mapa[6] = 1;
        } else if (turn == 2) {
            mapa[6] = 2;
        }
        return true;
    } else if (mapa[7] == 0 && posicion == 7) {
        cont++
        if (turn == 1) {
            mapa[7] = 1;
        } else if (turn == 2) {
            mapa[7] = 2;
        }
        return true;
    } else if (mapa[8] == 0 && posicion == 8) {
        cont++
        if (turn == 1) {
            mapa[8] = 1;
        } else if (turn == 2) {
            mapa[8] = 2;
        }
        return true;
    } else {
        if (turn == 1) {
            document.getElementById("juegan").innerHTML = "Casilla ocupada - Juegan X";
        } else {
            document.getElementById("juegan").innerHTML = "Casilla ocupada - Juegan O";
        }
        return false;
    }
}

function revisarJuego() {

    if ((mapa[0] == mapa[1]) && (mapa[1] == mapa[2])) {
        if (mapa[0] == 1 && mapa[1] == 1 && mapa[2] == 1) {
            reiniciarJuego();
        }
        if (mapa[0] == 2 && mapa[1] == 2 && mapa[2] == 2) {
            reiniciarJuego();
        }
    }

    if ((mapa[3] == mapa[4]) && (mapa[4] == mapa[5])) {
        if (mapa[3] == 1 && mapa[4] == 1 && mapa[5] == 1) {
            reiniciarJuego();
        }
        if (mapa[3] == 2 && mapa[4] == 2 && mapa[5] == 2) {
            reiniciarJuego();
        }
    }

    if ((mapa[6] == mapa[7]) && (mapa[7] == mapa[8])) {
        if (mapa[6] == 1 && mapa[7] == 1 && mapa[8] == 1) {
            reiniciarJuego();
        }
        if (mapa[6] == 2 && mapa[7] == 2 && mapa[8] == 2) {
            reiniciarJuego();
        }
    }

    if ((mapa[0] == mapa[3]) && (mapa[3] == mapa[6])) {
        if (mapa[0] == 1 && mapa[3] == 1 && mapa[6] == 1) {
            reiniciarJuego();
        }
        if (mapa[0] == 2 && mapa[3] == 2 && mapa[6] == 2) {
            reiniciarJuego();
        }
    }

    if ((mapa[1] == mapa[4]) && (mapa[4] == mapa[7])) {
        if (mapa[1] == 1 && mapa[4] == 1 && mapa[7] == 1) {
            reiniciarJuego();
        }
        if (mapa[1] == 2 && mapa[4] == 2 && mapa[7] == 2) {
            reiniciarJuego();
        }
    }

    if ((mapa[2] == mapa[5]) && (mapa[5] == mapa[8])) {
        if (mapa[2] == 1 && mapa[5] == 1 && mapa[8] == 1) {
            reiniciarJuego();
        }
        if (mapa[2] == 2 && mapa[5] == 2 && mapa[8] == 2) {
            reiniciarJuego();
        }
    }

    if ((mapa[0] == mapa[4]) && (mapa[4] == mapa[8])) {
        if (mapa[0] == 1 && mapa[4] == 1 && mapa[8] == 1) {
            reiniciarJuego();
        }
        if (mapa[0] == 2 && mapa[4] == 2 && mapa[8] == 2) {
            reiniciarJuego();
        }
    }

    if ((mapa[2] == mapa[4]) && (mapa[4] == mapa[6])) {
        if (mapa[2] == 1 && mapa[4] == 1 && mapa[6] == 1) {
            reiniciarJuego();
        }
        if (mapa[2] == 2 && mapa[4] == 2 && mapa[6] == 2) {
            reiniciarJuego();
        }
    }

    if (cont == 9 && fin == false) {
        document.getElementById("juegan").innerHTML = "EMPATE";
        turn = 0;
        reiniciarJuego();
    }
}

function reiniciarJuego() {
    if (turn == 1) {
        document.getElementById("juegan").innerHTML = "Ganan las O!";
    } else if (turn == 2) {
        document.getElementById("juegan").innerHTML = "Ganan las X!";
    }
    
    let button = document.createElement("input");
    button.setAttribute("id", "btn");
    button.setAttribute("type", "button");
    button.setAttribute("onclick", "reiniciamos()");
    button.setAttribute("value", "Reiniciar Juego");
    document.body.appendChild(button);
    fin = true;
}

function reiniciamos() {
    for (let index = 0; index < mapa.length; index++) {
        mapa[index] = 0;
        const element = document.getElementById("casilla");
        element.remove();
    }
    const element = document.getElementById("btn");
    element.remove();
    cont = 0;
    turn = 1;
    fin = false;
    principal();
}