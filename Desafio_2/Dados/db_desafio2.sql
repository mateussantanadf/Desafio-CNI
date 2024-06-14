-- Database: desafioCNI_2

-- DROP DATABASE IF EXISTS "desafioCNI_2";

CREATE DATABASE "desafioCNI_2"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE vendedores (
    vendedor_id smallint NOT NULL,
    name varchar(255),
    qtdItens smallint,
	totalVendido varchar(100),
	salario varchar(100)
);

INSERT INTO vendedores VALUES (1, 'Ronan', 10, 5800, 1200);
INSERT INTO vendedores VALUES (2, 'Carlos', 25, 6100, 1800);
INSERT INTO vendedores VALUES (3, 'Marta', 50, 8500, 1700);
INSERT INTO vendedores VALUES (4, 'Renata', 75, 4600, 1500);
INSERT INTO vendedores VALUES (5, 'Valter', 40, 3200, 2000);
INSERT INTO vendedores VALUES (6, 'Felipe', 48, 7654, 2000);
INSERT INTO vendedores VALUES (7, 'Gabriela', 73, 8765, 2900);
INSERT INTO vendedores VALUES (8, 'Hugo', 29, 5432, 1800);
INSERT INTO vendedores VALUES (9, 'Isabela', 56, 6543, 2300);
INSERT INTO vendedores VALUES (10, 'João', 42, 8765, 2600);
INSERT INTO vendedores VALUES (11, 'Karina', 88, 7654, 2100);
INSERT INTO vendedores VALUES (12, 'Lucas', 10, 4567, 1400);
INSERT INTO vendedores VALUES (13, 'Maria', 67, 6543, 2200);
INSERT INTO vendedores VALUES (14, 'Nuno', 19, 5678, 2500);
INSERT INTO vendedores VALUES (15, 'Olga', 53, 7654, 2400);
INSERT INTO vendedores VALUES (16, 'Elisa', 76, 8765, 2700);
INSERT INTO vendedores VALUES (17, 'Daniel', 25, 5432, 1700);
INSERT INTO vendedores VALUES (18, 'Clara', 61, 6543, 2300);
INSERT INTO vendedores VALUES (19, 'Bruno', 94, 7890, 3000);
INSERT INTO vendedores VALUES (20, 'Ana', 31, 6543, 2200);