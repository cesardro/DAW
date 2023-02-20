function cambiaSize() {
    let seleccion = $("#selecion").val();

    switch (seleccion) {
        case "14px":
            $("#titCap").css("font-size", "14px");
            $("#entrada").css("font-size", "14px");
            $("#parrafo").css("font-size", "14px");
            break;
        case "16px":
            $("#titCap").css("font-size", "16px");
            $("#entrada").css("font-size", "16px");
            $("#parrafo").css("font-size", "16px");
            break;
        case "20px":
            $("#titCap").css("font-size", "20px");
            $("#entrada").css("font-size", "20px");
            $("#parrafo").css("font-size", "20px");
            break;
        default:
            console.log("Error");
            break;
    }
}
