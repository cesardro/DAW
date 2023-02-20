//onload = principal;

function principal() {
    let text = "";

    let num = 0;
    num = parseInt(document.getElementById("num").value);

    for (let n = 1; n <= 10; n++) {
        text += n + " x " + num + " = " + (n * num) + "<br>";
    }
    document.getElementById('tabla').innerHTML = text;
}