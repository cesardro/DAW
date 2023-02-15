CREATE USER 'comentaLibrosTiempo'@'localhost' IDENTIFIED VIA mysql_native_password USING '***';
GRANT USAGE ON *.* TO 'comentaLibrosTiempo'@'localhost' REQUIRE NONE WITH MAX_QUERIES_PER_HOUR 0 
MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;
CREATE DATABASE IF NOT EXISTS `comentaLibrosTiempo`;
GRANT ALL PRIVILEGES ON `comentaLibrosTiempo`.* TO 'comentaLibrosTiempo'@'localhost';

mydb = mysql.connector.connect(
    host='localhost',
    user='comentaLibrosTiempo',
    password='comentaLibrosTiempo',
    database='comentaLibrosTiempo'
)

CREATE TABLE roles (
    id int NOT NULL AUTO_INCREMENT,
    descripcion varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE usuarios (
    id int NOT NULL AUTO_INCREMENT,
    usuario varchar(255) UNIQUE NOT NULL,
    passwd varchar(600) NOT NULL,
    mail varchar(255),
    rolId int,
    tmpRegistro datetime NOT NULL,
    FOREIGN KEY (rolId) REFERENCES roles(id),
    PRIMARY KEY (id)
);

CREATE TABLE comentarios (
    id INT NOT NULL AUTO_INCREMENT,
    titulo varchar(255) NOT NULL,
    autor varchar(255) NOT NULL,
    comentario varchar(3000) NOT NULL,
    usuarioId INT NOT NULL,
    imagen varchar(255),
    PRIMARY KEY (id),
    FOREIGN KEY (usuarioId) REFERENCES usuarios(id) ON DELETE CASCADE
);

CREATE TABLE regOperaciones (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    usuarioId INT NOT NULL,
    operacion varchar(255) NOT NULL,
    parametros varchar(3000) NOT NULL,
    tmpAccion datetime NOT NULL,
    FOREIGN KEY (usuarioId) REFERENCES usuarios(id) ON DELETE CASCADE
);

-- XXX, 2, "postea.py", "", "2022-11-23 09:13:21"
-- YYY, 2, "guardarEnBD.py", "titulo=dasdsad&...", "2022-11-23 19:32:42"