CREATE TABLE Resultados(
    ID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    EquipoLocal varchar(255) NOT NULL,
    EquipoVisitante varchar(255) NOT NULL,
    GolesLocal int NOT NULL,
    GolesVisitante int NOT NULL
);