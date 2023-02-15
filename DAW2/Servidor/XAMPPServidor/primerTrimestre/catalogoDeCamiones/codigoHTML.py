cabeceraHTML = """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <!-- Latest compiled and minified CSS -->
    <link href ="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel = " stylesheet ">
    
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js "></script>
    
    <!-- Se ha de poner brackets para cambiarlo en el otro codigo -->

    <!-- JavaScript de la aplicación web -->
    <script src="./js/vdc.js"></script>
    
    <title>VENTA DE CAMIONES</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-2"></div>
            <div class="col-8">
                <h3 class="display-3 text-center">Venta de camiones</h3>
                <div class="text-center"></div>
                <br>
                <div class="text-center"></div>
"""

cuerpoHTML = """
                  <div id='listaCamiones'></div>
"""

formulario = """
                <form">
                    <div class="mb-3 mt-3">
                        <label for="modelo" class="form-label">Modelo:</label>
                        <input type="text" class="form-control" id="modelo" aria-describedby="modeloAyuda" name="modelo">
                        <div id="modeloAyuda" class="form-text">Escribe el modelo del cami&oacute;n.</div>
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="marca" class="form-label">Marca:</label>
                        <input type="text" class="form-control" id="marca" aria-describedby="marcaAyuda" name="marca">
                        <div id="marcaAyuda" class="form-text">Escribe el marca del cami&oacute;n.</div>
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="precio" class="form-label">Precio:</label>
                        <input type="text" class="form-control" id="precio" aria-describedby="precioAyuda" name="precio">
                        <div id="precioAyuda" class="form-text">Escribe el precio del cami&oacute;n.</div>
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="desc" class="form-label">Descripci&oacute;n:</label>
                        <input type="text" class="form-control" id="desc" aria-describedby="descAyuda" name="desc">
                        <div id="descAyuda" class="form-text">Escribe el desc del cami&oacute;n.</div>
                    </div>
                    <button type="button" class="btn btn-primary" onclick="enviarCamion()">Enviar cami&oacute;n</button>
               </form>
"""

tarjetaCamion = """
<div class="card m-3">
  <div class="row g-0">
    <div class="col-md-6">
      <img src="#" class="img-fluid rounded-start" alt="Imagen camion" id="imagen">
    </div>
    <div class="col-md-6">
      <div class="card-body">
        <h5 class="card-title" id="modelo"></h5>
        <p class="card-text" id="marca"></p>
        <p class="card-text" id="precio"></p>
        <p class="card-text" id="descripcion"></p>
      </div>
    </div>
  </div>
</div>
"""


finalHTML = """
            </div>
            <div class="col-2"></div>
        </div>
    </div>
</body>
</html>
"""
