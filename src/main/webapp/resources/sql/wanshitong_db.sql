-- DROP SEQUENCE public.libros_id_seq;

CREATE SEQUENCE public.libros_id_seq
INCREMENT BY 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1;

-- DROP SEQUENCE public.reflexiones_id_seq;

CREATE SEQUENCE public.reflexiones_id_seq
INCREMENT BY 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1;


CREATE TABLE public.libros (
	id int4 NOT NULL DEFAULT nextval('libros_id_seq'::regclass),
	isbn int4 NULL,
	titulo varchar(100) NULL,
	autor varchar(100) NULL,
	genero varchar(100) NULL,
	CONSTRAINT libros_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
);


CREATE TABLE public.reflexiones (
	id int4 NOT NULL DEFAULT nextval('reflexiones_id_seq'::regclass),
	libro_id int4 NOT NULL,
	CONSTRAINT reflexiones_pkey PRIMARY KEY (id),
	CONSTRAINT reflexiones_libros_fk FOREIGN KEY (libro_id) REFERENCES public.libros(id)
)
WITH (
	OIDS=FALSE
);

﻿INSERT INTO public.libros (isbn,titulo,autor,genero) VALUES (
0,'Hercules','Anonimo','Mitologia');
INSERT INTO public.libros (isbn,titulo,autor,genero) VALUES (
0,'Estudio en escarlata','Arthur Conan Doyle','Suspenso');
INSERT INTO public.libros (isbn,titulo,autor,genero) VALUES (
0,'Ready Player One','Ernest Cline','Ficción');
    

