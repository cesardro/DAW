function new_div() {
    $(document).ready(function () {
        let test = {
            id: "div",
            class: "divclass",
            css: {
                color: "Green"
            }
        };
        let divisor = $("<div>", test);
        divisor.html("New Division");
        $("body").append(divisor);
    });
}
