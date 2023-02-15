cabeceraHTML = """
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>


    <title>{}</title>
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6 text-center">
                <h3 class="display-3">{}</h3>

"""

finalHTML = """
            </div>
            <div class="col-3"></div>
        </div>
    </div>
</body>
</html>
"""

redireccionHtml = """
<!DOCTYPE html>
<html lang="es">
<head>
  <meta http-equiv="Refresh" content="{}; URL={}" />
</head>
<body>
    <h3 class="Display-3">Saliendo...</h3>
</body>
</html>
"""

redireccion = lambda s,t : print(redireccionHtml.format(s,t))

def redireccionIndex():
    redireccion(3,"index.html")

def redireccionError():
    redireccion(0,"error.html")