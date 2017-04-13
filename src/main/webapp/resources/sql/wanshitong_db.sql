-- CREATE SEQUENCE FOR LIBROS

CREATE SEQUENCE public.libros_id_seq
INCREMENT BY 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1;

-- CREATE TABLE LIBROS

CREATE TABLE public.libros (
	id int4 NOT NULL DEFAULT nextval('libros_id_seq'::regclass),
	titulo varchar(100) NULL,
	autor varchar(100) NULL,
	genero varchar(100) NULL,
	tapa varchar(300) NULL,
	CONSTRAINT libros_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
);

-- CREATE SEQUENCE FOR USERS

CREATE SEQUENCE seguridad.user_id_seq
INCREMENT BY 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1;

-- CREATE SEQUENCE FOR ROLES

CREATE SEQUENCE seguridad.user_role_id_seq
INCREMENT BY 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1;


-- CREATE TABLE USERS

CREATE TABLE seguridad.users (
	id int4 NOT NULL DEFAULT nextval('seguridad.user_id_seq'::regclass),
	username varchar(100) NOT NULL,
	password varchar(100) NOT NULL,
	enabled bool not null default true,
	CONSTRAINT uni_username UNIQUE (username),
	CONSTRAINT user_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
);


-- CREATE TABLE USER_ROLES

CREATE TABLE seguridad.user_roles (
	user_role_id int4 NOT NULL DEFAULT nextval('seguridad.user_role_id_seq'::regclass),
	username varchar(100) NOT NULL,
	role varchar(100) NOT NULL,
	CONSTRAINT uni_username_rol UNIQUE (username,role),
	CONSTRAINT user_role_pkey PRIMARY KEY (user_role_id),
	CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES seguridad.users(username)
)
WITH (
	OIDS=FALSE
);


-- DATA FOR USERS

INSERT INTO seguridad.users (id,username,password,enabled) VALUES (
1,'sgilberto','Snalgo1608',true);
INSERT INTO seguridad.users (id,username,password,enabled) VALUES (
2,'prueba','asdqwe123',true);

-- DATA FOR ROLES

INSERT INTO seguridad.user_roles (user_role_id,username,role) VALUES (
1,'sgilberto','ROLE_ADMIN');
INSERT INTO seguridad.user_roles (user_role_id,username,role) VALUES (
2,'sgilberto','ROLE_USER');
INSERT INTO seguridad.user_roles (user_role_id,username,role) VALUES (
3,'prueba','ROLE_USER');

-- DATA FOR LIBROS

INSERT INTO public.libros (id,titulo,autor,genero,tapa) VALUES (
1,'18 segundos','George Shuman','Suspenso','https://s-media-cache-ak0.pinimg.com/236x/33/d3/ca/33d3ca2406ec6355326f6a23c7b2178a.jpg');
INSERT INTO public.libros (id,titulo,autor,genero,tapa) VALUES (
2,'Estudio en escarlata','Arthur Conan Doyle','Suspenso','https://4.bp.blogspot.com/-znVu7EAogNo/VHSDaVbfLCI/AAAAAAAAJuo/dKJRUxxRuGA/s1600/Estudio%2Ben%2Bescarlata1.png');
INSERT INTO public.libros (id,titulo,autor,genero,tapa) VALUES (
3,'El viejo y el mar','Ernest Hemingway','Literatura Universal','http://2.bp.blogspot.com/_c5qMl3yzEAM/TU-XaFPf1rI/AAAAAAAADMc/mbs5TMOrZZc/s1600/El%2Bviejo%2By%2Bel%2Bmar01.jpg');
INSERT INTO public.libros (id,titulo,autor,genero,tapa) VALUES (
4,'Ulises','James Joyce','Mitologia','https://imagessl8.casadellibro.com/a/l/t0/18/9788426418418.jpg');
INSERT INTO public.libros (id,titulo,autor,genero,tapa) VALUES (
5,'El psicoanalista','John Katzenbach','Suspenso','http://www.elresumen.com/libros/el_psicoanalista.jpg');
INSERT INTO public.libros (id,titulo,autor,genero,tapa) VALUES (
6,'Personas desconocidas','John Katzenbach','Suspenso','https://assets-production-webvanta-com.s3-us-west-2.amazonaws.com/000000/50/16/medium/portadas/PersonasDesconocidas.JPG');
INSERT INTO public.libros (id,titulo,autor,genero,tapa) VALUES (
7,'El jugador','Fiódor Dostoyevski','Literatura Universal','https://www.filepicker.io/api/file/HPFRl3saTBu68dYDZ3e4');

