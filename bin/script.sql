/*CREATE TABLE SPONSOR(
    idsponsor SERIAL PRIMARY KEY,
    monto money, 
    startdate date,
    enddate date 
    active boolean
)

CREATE TABLE SPONSORXANIMAL(
    idanimal int,
    idsponsor int
);
*/

DROP TABLE ESPECIE;
DROP TABLE UBICACION;
DROP TABLE ANIMAL;

CREATE TABLE ESPECIE(
    idespecie SERIAL PRIMARY KEY,
    nombre varchar(20)
);

CREATE TABLE UBICACION(
    idubicacion SERIAL PRIMARY KEY,
    nombreubicacion varchar(30)
);

CREATE TABLE ANIMAL (
    idanimal SERIAL PRIMARY KEY,
    nombre varchar(20),
    edad int,
    peso int,
    tiposangre varchar(10),
    descripcion text,
    idespecie int,
    idubicacion int,
    CONSTRAINT FK_especie FOREIGN KEY (idespecie) 
        REFERENCES ESPECIE(idespecie) 
        ON DELETE NO ACTION,
    CONSTRAINT FK_ubicacion FOREIGN KEY (idubicacion) 
        REFERENCES UBICACION(idubicacion) 
        ON DELETE NO ACTION
);

INSERT INTO ESPECIE(nombre) VALUES ('especie de prueba');
INSERT INTO UBICACION(nombreubicacion) VALUES ('lugar de prueba');
INSERT INTO ANIMAL(nombre, edad, peso, tiposangre, descripcion,idespecie, idubicacion) VALUES ('prueba', 12, 150, 'ORH+', 'Esto es solo una prueba', 1, 1);
INSERT INTO ANIMAL(nombre, edad, peso, tiposangre, descripcion,idespecie, idubicacion) VALUES ('prueba', 5, 150, 'verde musgo', 'Apadriname porfis', 1, 1);