-- Database: desafioCNI_1

-- DROP DATABASE IF EXISTS "desafioCNI_1";

CREATE DATABASE "desafioCNI_1"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE valores (
    value_id smallint NOT NULL,
    value_a smallint,
    value_b smallint
);

INSERT INTO valores VALUES (1, 50, 20);
INSERT INTO valores VALUES (2, 70, 50);
INSERT INTO valores VALUES (3, 80, 90);
INSERT INTO valores VALUES (4, 7, 55);
INSERT INTO valores VALUES (5, 88, 64);
INSERT INTO valores VALUES (6, 78, 85);
INSERT INTO valores VALUES (7, 32, 19);
INSERT INTO valores VALUES (8, 1, 5);
INSERT INTO valores VALUES (9, 6, 99);
INSERT INTO valores VALUES (10, 78, 25);
INSERT INTO valores VALUES (11, 32, 21);
INSERT INTO valores VALUES (12, 305, 77);
INSERT INTO valores VALUES (13, 500, 4);
INSERT INTO valores VALUES (14, 36, 103);
INSERT INTO valores VALUES (15, 32, 25);
INSERT INTO valores VALUES (16, 10, 66);
INSERT INTO valores VALUES (17, 46, 54);
INSERT INTO valores VALUES (18, 21, 55);
INSERT INTO valores VALUES (19, 32, 97);
INSERT INTO valores VALUES (20, 21, 54);