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
    nombre varchar(40),
    edad int,
    peso int,
    tiposangre varchar(20),
    descripcion text,
    idespecie int,
    idubicacion int,
    url_imagen text,
    CONSTRAINT FK_especie FOREIGN KEY (idespecie) 
        REFERENCES ESPECIE(idespecie) 
        ON DELETE NO ACTION,
    CONSTRAINT FK_ubicacion FOREIGN KEY (idubicacion) 
        REFERENCES UBICACION(idubicacion) 
        ON DELETE NO ACTION
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
    url_imagen text,
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

INSERT INTO ESPECIE(nombre) VALUES ('Castor');
INSERT INTO ESPECIE(nombre) VALUES ('Alce');
INSERT INTO ESPECIE(nombre) VALUES ('Elefante');

INSERT INTO UBICACION(nombreubicacion) VALUES ('Canada');
INSERT INTO UBICACION(nombreubicacion) VALUES ('Africa');

INSERT INTO ANIMAL(nombre, edad, peso, tiposangre, descripcion, idespecie, idubicacion, url_imagen) VALUES ('Norbert', 12, 50, 'ORH+', 'Amigable castor llamado Norbert que necesita tu ayuda para poder salvar su ecosistema.', 1, 1, 'https://upload.wikimedia.org/wikipedia/commons/5/54/Beaver-Szmurlo.jpg');
INSERT INTO ANIMAL(nombre, edad, peso, tiposangre, descripcion, idespecie, idubicacion, url_imagen) VALUES ('Bullwinkle', 5, 300, 'B+', 'Este Alce llamado Bullwinkle necesita de tu ayuda para poder protegerlo contra la caza furtiva.', 2, 1, 'https://misanimales.com/wp-content/uploads/2018/01/alce-caracteristicas.jpg');
INSERT INTO ANIMAL(nombre, edad, peso, tiposangre, descripcion, idespecie, idubicacion, url_imagen) VALUES ('Manyula', 23, 800, 'B-', 'Elefante llamado manyula que necesita de tu apoyo para poder brindarle comida saludable.', 3, 2, 'https://www.lavanguardia.com/r/GODO/LV/p5/WebSite/2018/10/04/Recortada/img_csaez_20181004-123213_imagenes_lv_otras_fuentes_dsc_9613-264-kNLG-U452167509016VOD-992x558@LaVanguardia-Web.jpg');


INSERT INTO EMAIL(email) VALUES ('ariel1234@gmail.com');
INSERT INTO EMAIL(email) VALUES ('roberto4312@gmail.com');

INSERT INTO PROVEEDOR(nombreproveedor, descproveedor, idemail) VALUES('Ariel', 'Provee una amplia variedad de juguetes de peluche', 1);
INSERT INTO PROVEEDOR(nombreproveedor, descproveedor, idemail) VALUES('Roberto','Provee una cantidad variada de rompecabezas', 2);

INSERT INTO PRODUCTO(nombreProducto,precio,descripcionProducto,calificacion,idproveedor, url_imagen) VALUES ('Peluche Castor',25,'Adorable peluche de un castor.', 10, 1,'https://images-na.ssl-images-amazon.com/images/I/91QU2f1rdHL._SY355_.jpg');
INSERT INTO PRODUCTO(nombreProducto,precio,descripcionProducto,calificacion,idproveedor, url_imagen) VALUES ('Rompecabezas Castor',10,'Rompecabezas de 100 piezas con tematica de castor', 9, 2,'https://images-na.ssl-images-amazon.com/images/I/71vR7BNqRRL._SX425_.jpg');

INSERT INTO SPONSOR(nombresponsor, monto) VALUES ('Josseh',300);
INSERT INTO SPONSOR(nombresponsor, monto) VALUES ('Rodrigo',200);
INSERT INTO SPONSOR(nombresponsor, monto) VALUES ('Merino',500);
INSERT INTO SPONSOR(nombresponsor, monto) VALUES ('Roberto',100);

INSERT INTO SPONSORXANIMAL(idanimal, idsponsor) VALUES (1, 1);
INSERT INTO SPONSORXANIMAL(idanimal, idsponsor) VALUES (2, 2);
INSERT INTO SPONSORXANIMAL(idanimal, idsponsor) VALUES (3, 3);
INSERT INTO SPONSORXANIMAL(idanimal, idsponsor) VALUES (3, 4);

