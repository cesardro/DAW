$(principal);

function principal() {
    $("p").click(function () {
        $(this).hide("slow", "swing", function () {
            $(this).show(2000);
        });
    });

    $("p").mouseenter(function () {
        $(this).css("background-color", "gray");
    });

    $("p").mouseleave(cambiaFondoBlanco);
}

function cambiaFondoBlanco() {
    $(this).css("background-color", "white");
}
