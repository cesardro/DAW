cabeceraHTML= """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset = "UTF-8">
    <meta http-equiv ="X-UA-Compatible" content = "IE=edge" >
    <meta name = "viewport" content="width=device-width,initial-scale=1.0">
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
finalHTML= """
            </div>
            <div class="col-3"></div>
        </div>
    </div>
</body>
</html>
"""

pagina1HTML="""
                <form action="pagina2.py" method="post"><button type="submit" class="btn btn-primary">Pagina 2</button></form>
                <hr>
                <form action="logout.py" method="post"><button type="submit" class="btn btn-primary">Logout</button></form>
            </div>
            <div class="col-3"></div>
        </div>
    </div>
</body>
</html>
"""

pagina2HTML="""
                <form action="pagina1.py" method="post"><button type="submit" class="btn btn-primary">Pagina 1</button></form>
                <hr>
                <form action="logout.py" method="post"><button type="submit" class="btn btn-primary">Logout</button></form>
            </div>
            <div class="col-3"></div>
        </div>
    </div>
</body>
</html>
"""