CREATE TABLE camiones (
    id int NOT NULL AUTO_INCREMENT,
    marca varchar(255),
    modelo varchar(255),
    descripcion varchar(255),
    precio float(10),
    imagen varchar(255),
    fechaCreacion datetime,
    PRIMARY KEY (id)
);
 
INSERT INTO
`camiones`(`marca`, `modelo`, `descripcion`, `precio`, `imagen`,fechaCreacion)
VALUES ('Volvo','FH 500','seminuevo',58500,'volvoFH500.jpg',now());
 
INSERT INTO
`camiones`(`marca`, `modelo`, `descripcion`, `precio`, `imagen`,fechaCreacion)
VALUES ('Scania','R 450 NTG','Siempre en garage',78500,'scania R450 NTG.webp',now()-1);
