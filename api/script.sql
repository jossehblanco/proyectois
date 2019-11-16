z/* PONER LOS DROP AQUI */
DROP TABLE ESPECIE;
DROP TABLE UBICACION;
DROP TABLE ANIMAL;
DROP TABLE PROVEEDOR;
DROP TABLE PRODUCTO;
DROP TABLE SPONSOR;


/* Modulo Sponsor*/
CREATE TABLE ESPECIE(
    idespecie SERIAL PRIMARY KEY,
    nombre varchar(20)
);

INSERT INTO ESPECIE(nombre) VALUES ('Castor');
INSERT INTO ESPECIE(nombre) VALUES ('Alce');
INSERT INTO ESPECIE(nombre) VALUES ('Elefante');


CREATE TABLE UBICACION(
    idubicacion SERIAL PRIMARY KEY,
    nombreubicacion varchar(30)
); 

INSERT INTO UBICACION(nombreubicacion) VALUES ('Canada');
INSERT INTO UBICACION(nombreubicacion) VALUES ('Africa');


CREATE TABLE USUARIO(
    idusuario SERIAL PRIMARY KEY,
    username varchar(50),
    password varchar(50),
    email varchar(50),
    active boolean
);


INSERT INTO USUARIO(username, password, email, active) VALUES ('jossehblanco', 'root', 'jossehblanco@gmail.com', true);
INSERT INTO USUARIO(username, password, email, active) VALUES ('alexanderrivz', 'toor', 'chris@tian.com', true);
INSERT INTO USUARIO(username, password, email, active) VALUES ('chocogamer', 'githubmaster', 'ariel@quitamanchas.com', true);


CREATE TABLE ANIMAL (
    idanimal SERIAL PRIMARY KEY,
    nombre varchar(40),
    edad int,
    peso int,
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

INSERT INTO ANIMAL(nombre, edad, peso, descripcion, idespecie, idubicacion, url_imagen) VALUES ('Norbert', 12, 50, 'Amigable castor llamado Norbert que necesita tu ayuda para poder salvar su ecosistema.', 1, 1, 'https://upload.wikimedia.org/wikipedia/commons/5/54/Beaver-Szmurlo.jpg');
INSERT INTO ANIMAL(nombre, edad, peso, descripcion, idespecie, idubicacion, url_imagen) VALUES ('Bullwinkle', 5, 300, 'Este Alce llamado Bullwinkle necesita de tu ayuda para poder protegerlo contra la caza furtiva.', 2, 1, 'https://misanimales.com/wp-content/uploads/2018/01/alce-caracteristicas.jpg');
INSERT INTO ANIMAL(nombre, edad, peso, descripcion, idespecie, idubicacion, url_imagen) VALUES ('Manyula', 23, 800, 'Elefante llamado manyula que necesita de tu apoyo para poder brindarle comida saludable.', 3, 2, 'https://www.lavanguardia.com/r/GODO/LV/p5/WebSite/2018/10/04/Recortada/img_csaez_20181004-123213_imagenes_lv_otras_fuentes_dsc_9613-264-kNLG-U452167509016VOD-992x558@LaVanguardia-Web.jpg');


CREATE TABLE SPONSOR(
   idsponsor SERIAL PRIMARY KEY,
   idanimal int,
   idusuario int,
   monto money,
   CONSTRAINT FK_idanimal FOREIGN KEY (idanimal) REFERENCES ANIMAL (idanimal),
   CONSTRAINT FK_idusuario FOREIGN KEY (idusuario) REFERENCES USUARIO (idusuario)
);

INSERT INTO SPONSOR(idanimal, idusuario, monto) VALUES (1, 1, 300);
INSERT INTO SPONSOR(idanimal, idusuario, monto) VALUES (2, 1, 200);
INSERT INTO SPONSOR(idanimal, idusuario, monto) VALUES (1, 2, 500);


/* Modulo Sponsor*/
CREATE TABLE PROVEEDOR (
    idproveedor SERIAL PRIMARY KEY,
    nombreproveedor varchar(20),
    descproveedor text,
    idemail int,
    CONSTRAINT FK_email FOREIGN KEY (idemail) 
        REFERENCES EMAIL(idemail) 
        ON DELETE NO ACTION    
);

INSERT INTO PROVEEDOR(nombreproveedor, descproveedor, idemail) VALUES('Ariel', 'Provee una amplia variedad de juguetes de peluche', 1);
INSERT INTO PROVEEDOR(nombreproveedor, descproveedor, idemail) VALUES('Roberto','Provee una cantidad variada de rompecabezas', 2);



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

INSERT INTO PRODUCTO(nombreProducto,precio,descripcionProducto,calificacion,idproveedor, url_imagen) VALUES ('Peluche Castor',25,'Adorable peluche de un castor.', 10, 1,'https://images-na.ssl-images-amazon.com/images/I/91QU2f1rdHL._SY355_.jpg');
INSERT INTO PRODUCTO(nombreProducto,precio,descripcionProducto,calificacion,idproveedor, url_imagen) VALUES ('Rompecabezas Castor',10,'Rompecabezas de 100 piezas con tematica de castor', 9, 2,'https://images-na.ssl-images-amazon.com/images/I/71vR7BNqRRL._SX425_.jpg');


CREATE TABLE COMENTARIO(
   idcomentario SERIAL PRIMARY KEY,
   idproducto int,
   idusuario int,
   texto text,
   CONSTRAINT FK_idproducto FOREIGN KEY (idproducto) REFERENCES PRODUCTO (idproducto),
   CONSTRAINT FK_idusuario FOREIGN KEY (idusuario) REFERENCES USUARIO (idusuario)
);

INSERT INTO COMENTARIO(idproducto, idusuario, texto) VALUES (1, 1, 'este producto es dinamita pura');
INSERT INTO COMENTARIO(idproducto, idusuario, texto) VALUES (1, 2, 'Lo mismo que dijo el usuario de arriba');
INSERT INTO COMENTARIO(idproducto, idusuario, texto) VALUES (1, 1, 'Ah no, ya no sirve :v');
