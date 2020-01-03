drop database renta_carro;

create database renta_carro;

use renta_carro;

create table licencias(
	id_licencia int not null primary key auto_increment,
    nombre varchar(25)
)Engine InnoDB;
    
create table clientes(
	id_clientes int not null primary key auto_increment,
    nombre varchar(25) not null,
    apellido varchar(25) not null,
    email varchar(50) not null,
    dui varchar(10),
    nit varchar(17),
    fecha_nacimiento varchar(10) not null,
    telefono varchar(9) not null,
    icono int not null,
    seguridad varchar(50) not null,
    id_licencia int not null,
    constraint q foreign key (id_licencia) references licencias(id_licencia)
		on delete cascade on update cascade
)Engine InnoDB;

create table extranjeros(
	id_extranjero int not null primary key,
    extranjero int not null,/* 1=Si, 0=No */
    fecha_expiracion varchar(10),
    constraint w foreign key (id_extranjero) references clientes(id_clientes)
		on delete cascade on update cascade
)Engine InnoDB;

create table marcas(
	id_marca int not null primary key auto_increment,
    nombre varchar(50) not null
)Engine InnoDB; 

create table modelos(
	id_modelo int not null primary key auto_increment,
    nombre varchar(50) not null,
    anio int not null,
    id_marca int not null,
    constraint e foreign key (id_marca) references marcas(id_marca)
		on delete cascade on update cascade
)Engine InnoDB;

create table vehiculos(
	id_vehiculo int not null primary key auto_increment,
    fecha_ingreso varchar(10) not null,
    color varchar(25) not null,
    placa varchar(7) not null,
    descripcion varchar(100) not null,
    precio double not null,
    estado int not null,/* 1=Ocupado, 0=Disponible */
    img varchar(1000) not null,
    id_modelo int not null,
    constraint r foreign key (id_modelo) references modelos(id_modelo)
		on delete cascade on update cascade
)Engine InnoDB;

create table historiales(
	id_historial int not null primary key auto_increment,
    fecha_inicio varchar(10) not null,
    fecha_fin varchar(10) not null,
    precio double not null,
    id_extranjero int not null,
    id_vehiculo int not null,
    constraint t foreign key (id_extranjero) references extranjeros(id_extranjero)
		on delete cascade on update cascade,
	constraint y foreign key (id_vehiculo) references vehiculos(id_vehiculo)
		on delete cascade on update cascade
)Engine InnoDB;

create table moras(
	id_mora int not null auto_increment primary key,
    dias int not null,
    total double not null,
    id_historial int not null,
    constraint u foreign key (id_historial) references historiales(id_historial)
		on delete cascade on update cascade
)Engine InnoDB;

create table partes(
	id_parte int not null primary key auto_increment,
    nombre varchar(50) not null,
    funcionamiento varchar(100) not null,
    tipo int not null/* 1=Mecanica, 2=Electrica, 3=Tapiceria */
)Engine InnoDB;

create table reparaciones(
	id_reparacion int not null primary key auto_increment,
    fecha_ingreso varchar(10) not null,
    descripcion varchar(100) not null,
    id_vehiculo int not null,
    id_parte int not null,
    constraint i foreign key (id_vehiculo) references vehiculos(id_vehiculo)
		on delete cascade on update cascade,
	constraint o foreign key (id_parte) references partes(id_parte) 
		on delete cascade on update cascade
)Engine InnoDB;

create table usuarios(
	id_usuario int not null primary key auto_increment,
    nombre varchar(50) not null,
    email varchar(50) not null,
    direccion varchar(100) not null,
    seguridad varchar(50) not null,
    tipo int not null /* 1=root, 2=administrador, 3=estandar */
)Engine InnoDB;

insert into licencias (nombre) values
	("Juvenil vehiculos"),
    ("Juvenil Motocicletas"),
    ("Licencia particular"),
    ("Licencia motociclista"),
    ("Licencia liviana"),
    ("Licencia pesada"),
    ("Licencia pesada-T");

insert into clientes (nombre, apellido, email, dui, nit, fecha_nacimiento, telefono, icono, seguridad, id_licencia)	values
	("Luis Humberto", "Gonzalez Moz", "lhgonzalezmoz@hotmail.com", "05949115-1", "1234-123456-123-1", "27-02-1995", "7719-4231", 1, "qweasdzxc", 1),
	("Valentina Elizabeth", "Barrios Duran", "aomeluna@gmail.com", "00255902-3", "7897-789456-789-7", "30-05-1997", "7880-9491", 3, "zxcasdqwe", 2),
	("Iris Ivette", "Moz Mejia", "irisivette@hotmail.com", "", "", "01-01-1998", "7719-1193", 9, "ewqdsacxz", 3);

insert into extranjeros (id_extranjero, extranjero, fecha_expiracion) values
	(1, 0, null),
    (2, 0, null),
    (3, 1, "22-01-2020");

insert into marcas (nombre) values
	("Hyundai"),
	("Honda"),
    ("Toyota");

insert into modelos (nombre, anio, id_marca) values
	("Elantra", 2010, 1),
    ("Grand Santa Fe", 2015, 1),
    ("Civic", 2004, 2),
    ("Auris", 2014, 3),
    ("Hilux", 2016, 3);

insert into vehiculos (fecha_ingreso, color, placa, descripcion, precio, estado, img, id_modelo) values
	("06-09-2019", "Azul", "045-653", "Este vehiculo puede ir muy rapido", 31.99, 0, "https://www.hyundaiusa.com/espanol/images/vehicles/pages/vlp/2020/elantra/main/hdri/se/2020-elantra-se-symphony-silver.jpg", 1),
    ("09-01-2019", "Rosado", "123-456", "Este vehiculo es el mas seguro que usted puede encontrar", 49.75, 0, "https://www.actualidadmotor.com/wp-content/uploads/2017/09/Hyundai-Grand-Santa-Fe-0.jpg", 2),
    ("07-07-2010", "Verde", "654-789", "Este vehiculo es el viejo pero el mas poderoso", 29.77, 0, "https://http2.mlstatic.com/honda-civic-2004-2005-hule-D_NQ_NP_966518-MLM25826998097_072017-F.jpg", 3);

insert into historiales(fecha_inicio, fecha_fin, precio, id_extranjero, id_vehiculo) values 
	("25-02-2019", "26-02-2019", 29.77, 1, 3),
    ("25-02-2019", "27-02-2019", 99.50, 3, 2),
    ("25-02-2019", "28-02-2019", 95.97, 2, 1),
    ("25-03-2019", "26-03-2019", 29.77, 2, 3),
    ("25-03-2019", "27-03-2019", 99.50, 1, 2),
    ("25-03-2019", "28-03-2019", 95.97, 3, 1),
    ("25-04-2019", "26-04-2019", 29.77, 3, 3),
    ("25-04-2019", "27-04-2019", 99.50, 2, 2),
    ("25-04-2019", "28-04-2019", 95.97, 1, 1);
    
insert into moras (dias, total, id_historial) values 
	(1, 32.16, 1),
    (2, 107.46, 3);    
    
insert into partes (nombre, funcionamiento, tipo) values
	("Solenoide", "Hacer algo en el motor", 1),
    ("Llantas", "Dar viento al motor y si se pone el aire tira vientesito", 1),
    ("Intermitentes", "Sirve para encender y apagar ambas vias del carro", 2);

insert into reparaciones(fecha_ingreso, descripcion, id_vehiculo, id_parte) values
	("10-12-2019", "No enciende las intermitentes", 2, 3);
    
insert into usuarios(nombre, email, direccion, seguridad, tipo) values
	("Silvia Andrea Estupinian Ungo", "silviaungo@gmail.com", "El salvador san salvador en mijicanos", "carlitos", 1),
    ("Eulalio Cornejo Emerson Montes", "eulaliooilalue@gmail.com", "UTEC adentro de la USAM del rosario", "hola123", 2),
    ("Azucena del Carmen Usaid Campos", "azualmuerzo@gmail.com", "En el planeta tierra, cerca del sol", "azuprovecho", 3);