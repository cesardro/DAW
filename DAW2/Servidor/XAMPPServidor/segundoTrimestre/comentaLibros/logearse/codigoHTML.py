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
    <title>{}</title>
    {}
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

interfaz = """
                    <tr>
                        <td style="display: flex; flex-direction: column; align-items: center;">
                            {}
                            <img src="img/{}" alt="Imagen del libro" style="width: 100%; max-width: 50%; margin: 20px auto;">
                        </td>
                        <td>
                            {}
                        </td>
                        <td>
                            {}
                        </td>
                    </tr>
"""

postea = """
                <form action="guardarEnBD.py" method="post" enctype="multipart/form-data">
                    <div class="mb-3 mt-3">
                        <label for="titulo" class="form-label">Titulo:</label>
                        <input type="text" class="form-control" id="titulo" placeholder="Introduce el titulo"
                            name="titulo">
                    </div>
                    <div class="mb-3">
                        <label for="autor" class="form-label">Autor:</label>
                        <input type="text" class="form-control" id="autor" placeholder="Introduce la autor" name="autor">
                    </div>
                    <div class="mb-3">
                        <label for="comentario" class="form-label">Comentario:</label>
                        <input type="text" class="form-control" id="comentario" placeholder="Introduce la comentario" name="comentario">
                    </div>
                    <div class="mb-3">
                        <label for="imagen" class="form-label">URL Imagen:</label>
                        <input type="file" name="filename" id="imagen"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Enviar</button>
                    <a href="http://www.servidor.es/comentaLibros/logearse/interfaz.py"><button type="button" class="btn btn-primary">Cancelar</button></a>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
"""

soyAdminHTML = """
                <table class="table">
                    <tr><th>Nombre</th><th>Admin</th><th>Borrar</th><th>Historial</th></tr>
                    {}
            </div>
            <div class="col-3"></div>
        </div>
    </div>
</body>
</html>
"""

historialAdminHTML = """
                <table class="table">
                    <tr><th>ID</th><th>Usuario ID</th><th>Operacion</th><th>Parametros</th><th>Tiempo Accion</th></tr>
"""
