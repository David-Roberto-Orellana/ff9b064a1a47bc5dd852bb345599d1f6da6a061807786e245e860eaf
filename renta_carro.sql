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
	("Valentina Elizabeth", "Barrios Duran", "aomeluna@gmail.com", "00255902-3", "7897-789456-789-7", "30-05-2019", "7880-9491", 3, "zxcasdqwe", 2),
	("Iris Ivette", "Moz Mejia", "irisivette@hotmail.com", "00577082-0", "4567-456789-456-4", "01-01-2019", "7719-1193", 5, "ewqdsacxz", 3),
	("Luis Humberto", "Gonzalez Moz", "lhgonzalezmoz@hotmail.com", "05949115-1", "1234-123456-123-1", "27-02-2019", "7719-4231", 1, "qweasdzxc", 1),
	("Karla Azucena", "Rivas Corvera", "azucenarivas@hotmail.com", "01968426-1", "1531-123252-123-1", "19-07-1992", "7294-3805", 4, "colocha1", 5),
    ("David Roberto", "Orellana Galan", "davidorellanagalan@gmail.com", "02498589-1", "1222-123252-163-1", "11-06-1996", "7799-4431", 19, "david1", 5),
	("Diego Ernesto", "Alfaro Menendez", "diegoalfaro533@gmail.com", "05343212-1", "1623-525222-123-1", "30-03-2000", "6428-9069", 1, "maserati", 4),
	("Cesar Josue", "Murcia Gomez", "mg18045@ues.edu.sv", "05945515-1", "1234-123456-123-1", "23-03-1998", "7014-9398", 6, "bateyss", 3),
	("William Ricardo", "Rivas Lopez", "ricardo.insedro@gmail.com", "02498589-1", "1222-123252-163-1", "12-07-1996", "7003-4431", 4, "r6w6l6r6", 4),
	("Kevin Santiago", "Paz Vasquez", "kevinsanpaz@gmail.com", "06458588-1", "1244-061098-183-4", "06-10-1998", "7494-6692", 2, "kevinkevin", 5),
	("Silvia Andrea", "Estupinian Ungo", "silviaandraestupinian@hotmail.com", "06458588-1", "0614-012121-185-4", "12-11-1997", "7599-6929", 12, "silviaa", 4);

insert into extranjeros (id_extranjero, extranjero, fecha_expiracion) values
	(1, 0, null),
    (2, 0, null),
    (3, 1, "22-01-2020"),
    (4, 0, null),
    (5, 0, null),
    (6, 0, null),
    (7, 0, null),
    (8, 0, null),
    (9, 0, null),
    (10, 1, "01-01-2020");

insert into marcas (nombre) values
	("Hyundai"),
	("Honda"),
    ("Toyota"),
    ("Jeep"),
    ("Alfa Romero"),
    ("BMW"),
    ("Audi"),
    ("Nissan"),
    ("Aston Martin"),
    ("Bentley"),
    ("Cadillac"),
    ("Bugatti"),
    ("Ferrari"),
    ("Ford"),
	("Tesla");

insert into modelos (nombre, anio, id_marca) values
	/*Hyndai*/
    ("Elantra", 2020, 1),
	("Genesis", 2016, 1),
	/*Honda*/
	("Jazz", 2018, 2),
	("Civic", 2020, 2),
	/*Toyota*/
    ("Yaris", 2020, 3),
	("Corolla", 2019, 3),
	/*Jeep*/
    ("Grand Cherokee", 2018, 4),
	("Compass", 2019, 4),
	/*Alfa Romeo*/
    ("Tonale", 2019, 5),
	("4C", 2018, 5),
	/*BMW*/
    ("i8", 2019, 6),
	("M4", 2015, 6),
    /*Audi*/
    ("A5", 2020, 7),
	("A1", 2019, 7),
    /*Nissan*/
    ("GTR", 2019, 8),
	("X-Trail", 2020, 8),
    /*Aston Martin*/
    ("DBS", 2019, 9),
	("DB11", 2018, 9),
    /*Bentley*/
    ("Continental", 2020, 10),
	("Flying Spur", 2017, 10),
    /*Cadilac*/
    ("Deville", 1977, 11),
	("Buick LeSabre", 1951, 11),
	/*Bugatti*/
    ("Divo", 2018, 12),
	("Veyron", 2018, 12),
    /*Ferrari*/
    ("458", 2018, 13),
	("portofino", 2016, 13),
    /*Ford*/
    ("Scape", 2019, 14),
	("Explorer", 2019, 14),
     /*Ford*/
    ("Model S", 2019, 15),
	("Cybertruck", 2020, 15);
    
insert into vehiculos (fecha_ingreso, color, placa, descripcion, precio, estado, img, id_modelo) values
	("06-09-2019", "Gris", "055-213", "Nuevo Hyundai Elantra, completamente nitido y confortable", 54.99, 0, 
    "https://upload.wikimedia.org/wikipedia/commons/d/d2/2019_Hyundai_Elantra_Limited_%28AD_facelift%29_front_NYIAS_2019.jpg", 
    1),
    ("05-07-2019", "Rojo", "044-633", "Un Hyundai bastante moderno, lo ideal para viajes largos", 31.99, 0, 
    "https://st.motortrendenespanol.com/uploads/sites/45/2016/08/2016-Hyundai-Genesis-coupe-front-three-quarter.jpg", 
    2),
    ("01-09-2019", "Blanco", "035-353", "Este es un Honda, bastante ideal para calles estrechas", 40.99, 0, 
    "https://upload.wikimedia.org/wikipedia/commons/6/68/2018_Honda_Jazz_%28GK5_MY18%29_VTi-S_hatchback_%282018-08-06%29_01.jpg", 
    3),
    ("23-10-2019", "Azul", "095-609", "Un Honda de un color bastante llamativo, veloz y comodo", 43.99, 0, 
    "https://cdn.motor1.com/images/mgl/MQWXX/s1/2020-honda-civic-si-coupe.jpg", 
    4),
    ("12-07-2019", "Azul", "015-640", "este carro es de un tamaño pequeño ideal para ciudadanos", 45.49, 0, 
    "https://cdn.motor1.com/images/mgl/Q96lY/s1/2020-toyota-yaris-hatchback.jpg", 
    5),
    ("13-12-2019", "Cobre", "095-609", "Este carro es ideal manejar en la ciudad y es de 4 puertas", 38.94, 0, 
    "https://motor.elpais.com/wp-content/uploads/2019/09/toyotacorollatrek-lanzamiento2-162227.jpg", 
    6),
	("25-02-2019", "rojo", "007-609", "Esta camioneta es de tipo familiar", 46.99, 0, 
    "https://www.autobild.es/sites/autobild.es/public/dc/fotos/JeepGrandCherokee_01.jpg", 
    7),
	("01-10-2019", "negro", "090-600", "Esta camioneta es buena para un ambiente de trabajo", 48.99, 0, 
    "  https://s.aolcdn.com/commerce/autodata/images/USC70JES203B021001.jpg  ", 
    8),
	("01-12-2019", "rojo", "095-609", "esta camioneta es de 2 puertas y de un buen estilo", 45.98, 0, 
    " https://www.diariomotor.com/imagenes/2019/03/alfa-romeo-tonale-concept-6.jpg   ", 
    9),
	("02-10-2019", "verde", "087-689", "Este vehiculo es de tipo deportivo, de dos puertas y muy buen estilo", 50.99, 0, 
    "https://i.pinimg.com/originals/8a/38/a8/8a38a8f734fcd9eda892eeeac486539e.jpg", 
    10),
	("04-02-2019", "cafe", "099-909", "Este vehiculo es convertible, de 2 puertas", 48.99, 0, 
    "https://cdn.motor1.com/images/mgl/brBmj/s1/2019-bmw-i8-roadster-review.jpg  ", 
    11),
	("03-11-2019", "dorado", "090-379", "Este vehiculo es de tipo deportivo con un estilo muy increible", 55.59, 0, 
    "  https://www.wallpaperflare.com/static/907/794/330/auto-yellow-side-view-style-wallpaper.jpg  ", 
    12),
	("06-11-2019", "verde oscuro", "101-102", "Este vehiculo es de 2 puertas es muy comodo y de ciudad  ", 47.99, 0, 
    "  https://cdn.motor1.com/images/mgl/QE373/s1/2020-audi-a5-coupe.jpg  ", 
    13),
	("24-10-2019", "amarillo", "555-606", "Este vehiculo es de un ambiente de ciudad y es muy rapido", 47.89, 0, 
    "https://cdn.motor1.com/images/mgl/kJ6LN/s1/audi-a1-sportback-by-abt.jpg  ", 
    14),
	("01-03-2019", "rojo", "091-601", "Este vehiculo es muy comodo y de bastante sensibilidad   ", 55.99, 0, 
    "https://cdn.motor1.com/images/mgl/KqBrN/s1/nissan-gt-r-2020.jpg ", 
    15),
	("22-11-2019", "naranja", "888-609", "Esta camioneta es de ambiente familiar y es de 4 puetas  ", 45.99, 0, 
    "https://s1.1zoom.me/b4853/429/Nissan_X-Trail_Brown_Crossover_521809_3840x2160.jpg  ", 
    16),
	("25-01-2019", "verde", "044-701", "Este vehiculo esta en un buen estado es de 2 puertas ", 50.99, 0, 
    " https://cnet4.cbsistatic.com/img/O8xwlt9N75i6Ppyl2QJQfrmd9Gc=/1092x0/2019/04/19/cfd24de0-0cec-448f-9c98-95618d072564/dbs-59-promo.jpg ", 
    17), 
	("27-05-2019", "gris", "888-609", "Este vehiculo es de buen estilo, es potente y con un buen estado ", 51.99, 0, 
    "https://noticias.coches.com/wp-content/uploads/2019/09/startech_aston-martin-db11-2018_r18.jpg  ", 
    18),
	("30-11-2019", "anaranjado", "523-671", " este vehiculo es muy comodo y deportivo de bastante sensibilidad   ", 55.99, 0, 
    "  https://autonxt.net/wp-content/uploads/2019/08/2020_Bentley_Continental_GT_V8_18.jpg ", 
    19),
	("29-05-2019", "azul", "898-699", "  este vehiculo tiene buena iluminacion y es automatico ", 43.89, 0, 
    "https://cdn.motor1.com/images/mgl/Vo1j7/s1/bentley-flying-spur-special-edition.jpg  ", 
    20),
	("12-09-2019", "blanco", "891-205", " este es un vehiculo clasico, es una reliquia de la antigüedad", 80.99, 0, 
    "   https://i.ebayimg.com/00/s/MTIwMFgxNjAw/z/RfYAAOSwwYtc8tgN/$_57.JPG?set_id=8800005007 ", 
    21),
	("28-04-2019", "celeste con blanco ", "893-303", "  este vehiculo es muy lujoso por ser un carro futurista para su epoca  ", 60.99, 0, 
    "https://www.car-revs-daily.com/wp-content/uploads/old/Atlanta-Dream-Cars-1951-General-Motors-LeSabre-XP-8-Struck-Gold-With-Yank-Tank-Ethos-of-1950s-161.jpg  ", 
    22),
	("01-03-2019", "gris con azul", "797-701", " este vehiculo es famoso por su alta velocidad y su alto costo", 85.99, 0, 
    "   https://upload.wikimedia.org/wikipedia/commons/1/16/Bugatti_Divo%2C_GIMS_2019%2C_Le_Grand-Saconnex_%28GIMS0029%29.jpg ", 
    23),
	("24-07-2019", "negro con anaranjado", "878-679", "  este vehiculo es muy reconocido por su alta velocidad y su hermoso estilo", 87.99, 0, 
    "https://www.motortrend.com/uploads/sites/5/2019/10/Bugatti-Veyron-Super-Sport-Top-Gear-1.jpg  ", 
    24),
	("30-12-2019", "rojo", "290-001", " un vehiculo con buena velocidad y es una de las mejores marcas  ", 55.99, 0, 
    " https://www.diariomotor.com/imagenes/picscache/1920x1600c/ferrari-458-italia-1010_1920x1600c.jpg ", 
    25),
	("31-11-2019", "gris", "778-779", "Un vehiculo convertible y muy buen diseño y excelente apariencia  ", 57.99, 0, 
    "https://luxuryrentalscars.com/wp-content/uploads/2019/07/oirtofino.02.jpg  ", 
    26),
	("01-03-2019", "cafe oscuro", "494-601", " una camioneta bien espaciosa y con muy buena comodidad   ", 47.99, 0, 
    "   https://m.media-amazon.com/images/I/71fKWBvyybL.jpg", 
    27),
	("04-11-2019", "azul", "458-409", "  es una camioneta muy amplia y con mucha resistencia   ", 48.79, 0, 
    "https://uncrate.com/p/2019/01/ford-explorer-st-1.jpg  ", 
    28),
	("08-05-2019", "rojo", "441-601", " es un vehiculo con doble traccion, es estandar y es un carro para terrenos planos   ", 62.99, 0, 
    "   https://www.teslarati.com/wp-content/uploads/2019/10/Tesla-Model-S-Plaid-Nurburgring-3.jpg ", 
    29),
	("07-07-2019", "gris", "868-606", "Esta camioneta es blindada y es lo ultimo en tecnologias   ", 90.99, 0, 
    "https://cdn2.autoexpress.co.uk/sites/autoexpressuk/files/2019/11/image-from-ios-3_10.jpg ", 
    30);
    
insert into historiales(fecha_inicio, fecha_fin, precio, id_extranjero, id_vehiculo) values 
	("25-01-2019", "25-02-2019", 1704.99, 1, 1),
    ("20-03-2019", "27-03-2019", 255.99, 3, 2),
    ("15-03-2019", "15-04-2019", 1270.99, 2, 3),
    ("15-05-2019", "20-05-2019", 219.99, 2, 4),
    ("20-05-2019", "27-05-2019", 367.99, 1, 5),
	("30-06-2019", "01-07-2019", 38.94, 1, 6),
    ("20-06-2019", "26-06-2019", 281.99, 3, 7),
    ("01-07-2019", "11-07-2019", 489.9, 2, 8),
    ("12-07-2019", "14-07-2019", 91.96, 2, 9),
    ("01-10-2019", "05-10-2019", 99.50, 1, 10);
    
insert into moras (dias, total, id_historial) values 
	(1, 32.16, 1),
    (2, 107.46, 5);    
    
insert into partes (nombre, funcionamiento, tipo) values
    /*1.mecanica,2.electrica,3.tapiceria*/
    ("Solenoide", "Hacer algo en el motor", 1),
    ("Llantas", "Dar viento al motor y si se pone el aire tira vientesito", 1),
    ("Intermitentes", "Sirve para encender y apagar ambas vias del carro", 2),
	("Manijas", "Poder abrir el carro", 1),
	("Sube Vidrios", "Sube y baja los vidrios del carro", 2),
	("Radio", "Sintoniza las emisoras para poder escuchar musica o estado del trafico", 2),
	("Aire acondicionado", "Refresca el interior el vehiculo", 2);

insert into reparaciones(fecha_ingreso, descripcion, id_vehiculo, id_parte) values
	("10-12-2019", "No enciende las intermitentes", 2, 3);
    
insert into usuarios(nombre, email, direccion, seguridad, tipo) values
	("Usuario Root", "Rootuser@gmail.com","San Salvador, San Salvador", "Passwordinc", 1),
    ("Eulalio Cornejo Emerson Montes", "eulaliooilalue@gmail.com", "Apopa, Chintu 2", "hola123inc", 2),
    ("Azucena del Carmen Usaid Campos", "azualmuerzo@gmail.com", "En el planeta tierra, cerca del sol", "azuprovechoinc", 3),
	("Jocelyn Stefany de Paz Castellanos", "zenji@hotmail.com", "Soyapango, Amatepec","Jossinc",3),
    ("Josue Alexander Cruz Guerra","CCGuerra1@hotmail.com","San Jacinto, Col.Costa Rica","Guerrapazinc",3);

delimiter $
	create trigger q after insert on reparaciones
    for each row
    begin
    update vehiculos set estado = 1 where id_vehiculo = new.id_vehiculo;
    end $
delimiter ;

delimiter $
	create trigger w after delete on reparaciones
    for each row
    begin
    update vehiculos set estado = 0 where id_vehiculo = old.id_vehiculo;
    end $
delimiter ;

delimiter $
	create trigger e after insert on historiales
    for each row
    begin
    update vehiculos set estado = 1 where id_vehiculo = new.id_vehiculo;
    end $
delimiter ;

select * from renta_carro.usuarios;

select * from renta_carro.clientes;

select * from renta_carro.extranjeros;