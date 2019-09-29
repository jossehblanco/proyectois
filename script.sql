/* PONER LOS DROP AQUI */
DROP TABLE ESPECIE;
DROP TABLE UBICACION;
DROP TABLE ANIMAL;
DROP TABLE EMAIL;
DROP TABLE PROVEEDOR;
DROP TABLE PRODUCTO;
DROP TABLE SPONSOR;
DROP TABLE SPONSORXANIMAL;


/*PONER LOS CREATE TABLE AQUI */
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
        ON DELETE NO ACTION,
);

CREATE TABLE EMAIL (
    idemail SERIAL PRIMARY KEY,
    email varchar(50)    
);




CREATE TABLE PROVEEDOR (
    idproveedor SERIAL PRIMARY KEY,
    nombreproveedor varchar(20),
    descproveedor text,
    idemail int,
    CONSTRAINT FK_email FOREIGN KEY (idemail) 
        REFERENCES EMAIL(idemail) 
        ON DELETE NO ACTION    
);


CREATE TABLE PRODUCTO(
	idproducto SERIAL PRIMARY KEY,
	nombreProducto varchar(20),
	precio money,
	descripcionproducto text,
	calificacion int,
	idproveedor int,
	CONSTRAINT FK_idProveedor FOREIGN KEY (idproveedor)
	 REFERENCES PROVEEDOR(idproveedor)
	 ON DELETE NO ACTION 
);


CREATE TABLE SPONSOR(
   idsponsor SERIAL PRIMARY KEY,
   nombresponsor VARCHAR(50),
   monto money
);

CREATE TABLE SPONSORXANIMAL(
    idsponsorxanimal SERIAL PRIMARY KEY,
    idanimal int,
    idsponsor int,
    CONSTRAINT FK_idanimal FOREIGN KEY (idanimal)
    REFERENCES ANIMAL(idanimal),
    CONSTRAINT FK_idsponsor FOREIGN KEY (idsponsor)
    REFERENCES SPONSOR(idsponsor)
);


/*Poner los inserts aqui */

INSERT INTO ESPECIE(nombre) VALUES ('especie de prueba');
INSERT INTO UBICACION(nombreubicacion) VALUES ('lugar de prueba');
INSERT INTO ANIMAL(nombre, edad, peso, tiposangre, descripcion, idespecie, idubicacion) VALUES ('prueba', 12, 150, 'ORH+', 'Esto es solo una prueba', 1, 1);
INSERT INTO ANIMAL(nombre, edad, peso, tiposangre, descripcion, idespecie, idubicacion) VALUES ('prueba', 5, 150, 'verdemusgo', 'Apadriname porfis', 1, 1);
INSERT INTO ANIMAL(nombre, edad, peso, tiposangre, descripcion, idespecie, idubicacion) VALUES ('Ariel', 23, 350, 'choco', 'Me rento', 1, 1);


INSERT INTO EMAIL(email) VALUES ('arielchocogamer@gmail.com');
INSERT INTO EMAIL(email) VALUES ('robertololilover@gmail.com');

INSERT INTO PROVEEDOR(nombreproveedor, descproveedor, idemail) VALUES('Ariel', 'Provee juguetitos cool', 1);
INSERT INTO PROVEEDOR(nombreproveedor, descproveedor, idemail) VALUES('Roberto','Provee peluches turbo cool', 2);

INSERT INTO PRODUCTO(nombreProducto,precio,descripcionProducto,calificacion,idproveedor) VALUES ('prueba',500,'descripcion de producto', 10, 1);
INSERT INTO PRODUCTO(nombreProducto,precio,descripcionProducto,calificacion,idproveedor) VALUES ('prueba2',400,'descripcion de producto 2', 5, 1);

INSERT INTO SPONSOR(nombresponsor, monto) VALUES ('Josseh',300);
INSERT INTO SPONSOR(nombresponsor, monto) VALUES ('Rodrigo',200);
INSERT INTO SPONSOR(nombresponsor, monto) VALUES ('Merino',500);
INSERT INTO SPONSOR(nombresponsor, monto) VALUES ('Roberto',100);

INSERT INTO SPONSORXANIMAL(idanimal, idsponsor) VALUES (1, 1);
INSERT INTO SPONSORXANIMAL(idanimal, idsponsor) VALUES (2, 2);
INSERT INTO SPONSORXANIMAL(idanimal, idsponsor) VALUES (5, 3);
INSERT INTO SPONSORXANIMAL(idanimal, idsponsor) VALUES (5, 4);

