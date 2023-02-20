$("p").bind("click", function () {
    $("<div>Esto es un evento de click</div>").appendTo("body");
});

$("p").bind("dblclick", function () {
    $("<div>Esto es un evento de doble click</div>").appendTo("body");
});
