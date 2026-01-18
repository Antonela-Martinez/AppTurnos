create table USUARIOS(
	ID bigint not null AUTO_INCREMENT,
	dni bigint not null,
	nombre varchar(50),
	apellido varchar(50),
	telefono bigint,
	PRIMARY KEY(ID)
);

create table PROFESORES(
	ID bigint not null,
	datos_acceso_id bigint not null,
	discriminator boolean not null,
	PRIMARY KEY(ID)
);

alter table PROFESORES add constraint PRO$USU foreign key (ID) references USUARIOS(ID);

create table CLIENTES(
	ID bigint not null,
	email varchar(100) not null,
	PRIMARY KEY(ID)
);

//CREAMOS UNA TABLA HIJA CON EL CUAL HACE REFERENCIA AL PADRE PERO SIN ID AUTOINCREMENTAL
alter table CLIENTES add constraint CLI$USU foreign key (ID) references USUARIOS(ID);

create table DATOS_ACCESO(
	ID bigint not null AUTO_INCREMENT,
	email_us varchar(50) not null,
	clave varchar(25) not null,
	estado boolean,
	PRIMARY KEY(ID)
);

CREATE TABLE SERVICIOS (
	ID bigint not null AUTO_INCREMENT,
	nombre VARCHAR(50) not null,
	descripcion VARCHAR(255),
	precio INTEGER not null,
	duracion INTEGER,
	estado BOOLEAN,
	PRIMARY KEY(ID)
);

CREATE TABLE RESERVAS (
	ID bigint not null AUTO_INCREMENT,
	fecha DATETIME,
	hora INTEGER,
	cliente_id bigint,
	prof_id bigint,
	servicio_id bigint,
	PRIMARY KEY(ID)
);



ALTER TABLE PROFESIONALES ADD FOREIGN KEY(ID) REFERENCES RESERVAS(prof_id);

ALTER TABLE PROFESIONALES ADD FOREIGN KEY(datos_acceso_id) REFERENCES DATOS_ACCESO (ID);

ALTER TABLE CLIENTES ADD FOREIGN KEY (ID) REFERENCES RESERVAS(cliente_id);

ALTER TABLE SERVICIOS ADD FOREIGN KEY(ID) REFERENCES RESERVAS(servicio_id);





