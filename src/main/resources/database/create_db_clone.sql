CREATE TABLE USUARIOS(
	ID bigint not null AUTO_INCREMENT,
	dni bigint not null,
	nombre varchar (50) not null,
	apellido varchar(50) not null,
	telefono bigint not null,
	PRIMARY KEY(ID)
);

create table PROFESIONALES(
	ID bigint not null,
	datos_acceso_id bigint not null,
	discriminator varchar(50) not null,
	PRIMARY KEY(ID)
);

alter table PROFESIONALES add constraint PRO$USU foreign key (ID) references USUARIOS(ID);

create table CLIENTES(
	ID bigint not null,
	email varchar(100) not null,
	PRIMARY KEY(ID)
);

-- CREAMOS UNA TABLA HIJA CON EL CUAL HACE REFERENCIA AL PADRE PERO SIN ID AUTOINCREMENTAL
alter table CLIENTES add constraint CLI$USU foreign key (ID) references USUARIOS(ID);

create table DATOS_ACCESO(
	ID bigint not null AUTO_INCREMENT,
	email_us varchar(50) not null,
	clave varchar(25) not null,
	estado varchar(50),
	PRIMARY KEY(ID)
);

CREATE TABLE SERVICIOS (
	ID bigint not null AUTO_INCREMENT,
	nombre VARCHAR(50) not null,
	descripcion VARCHAR(255),
	precio INTEGER not null,
	duracion INTEGER,
	estado varchar(50),
	PRIMARY KEY(ID)
);

CREATE TABLE RESERVAS (
	ID bigint not null AUTO_INCREMENT,
	fecha DATETIME not null,
	hora INTEGER not null,
	cliente_id bigint not null,
	prof_id  bigint not null,
	servicio_id  bigint not null,
	PRIMARY KEY(ID)
);



ALTER TABLE RESERVAS ADD CONSTRAINT PROF$RE FOREIGN KEY(prof_id) REFERENCES PROFESIONALES(ID);

ALTER TABLE PROFESIONALES ADD FOREIGN KEY(datos_acceso_id) REFERENCES DATOS_ACCESO (ID);

ALTER TABLE RESERVAS ADD FOREIGN KEY (cliente_id) REFERENCES CLIENTES(ID);

ALTER TABLE RESERVAS ADD FOREIGN KEY(servicio_id) REFERENCES SERVICIOS(ID));