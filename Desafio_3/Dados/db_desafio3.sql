-- Database: desafioCNI_3

-- DROP DATABASE IF EXISTS "desafioCNI_3";

CREATE DATABASE "desafioCNI_3"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE cliente (
    cliente_id smallint NOT NULL,
    name varchar(255),
    qtdComprada smallint
);

INSERT INTO cliente VALUES (1, 'Ana', 17);
INSERT INTO cliente VALUES (2, 'Bruno', 28);
INSERT INTO cliente VALUES (3, 'Carla', 9);
INSERT INTO cliente VALUES (4, 'Renata', 22);
INSERT INTO cliente VALUES (5, 'Valter', 14);
INSERT INTO cliente VALUES (6, 'Felipe', 31);
INSERT INTO cliente VALUES (7, 'Gabriela', 5);
INSERT INTO cliente VALUES (8, 'Hugo', 19);
INSERT INTO cliente VALUES (9, 'Isabela', 8);
INSERT INTO cliente VALUES (10, 'João', 12);
INSERT INTO cliente VALUES (11, 'Karina', 27);
INSERT INTO cliente VALUES (12, 'Lucas', 3);
INSERT INTO cliente VALUES (13, 'Maria', 33);
INSERT INTO cliente VALUES (14, 'Nuno', 24);
INSERT INTO cliente VALUES (15, 'Olga', 7);
INSERT INTO cliente VALUES (16, 'Elisa', 6);
INSERT INTO cliente VALUES (17, 'Daniel', 25);
INSERT INTO cliente VALUES (18, 'Clara', 11);
INSERT INTO cliente VALUES (19, 'Bruno', 16);
INSERT INTO cliente VALUES (20, 'Ana', 20);