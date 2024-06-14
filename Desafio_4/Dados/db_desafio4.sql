-- Database: desafioCNI_4

-- DROP DATABASE IF EXISTS "desafioCNI_4";

CREATE DATABASE "desafioCNI_4"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE hora (
    hora_id smallint NOT NULL,
    hora_inicio time,
    hora_termino time
);

INSERT INTO hora VALUES (1, '06:30', '17:15');
INSERT INTO hora VALUES (2, '08:20', '09:15');
INSERT INTO hora VALUES (3, '10:45', '11:30');
INSERT INTO hora VALUES (4, '10:10', '12:55');
INSERT INTO hora VALUES (5, '05:40', '17:40');
INSERT INTO hora VALUES (6, '05:15', '18:00');
INSERT INTO hora VALUES (7, '09:50', '17:35');
INSERT INTO hora VALUES (8, '18:25', '19:10');
INSERT INTO hora VALUES (9, '12:55', '20:40');
INSERT INTO hora VALUES (10, '21:30', '22:15');
INSERT INTO hora VALUES (11, '08:05', '17:50');
INSERT INTO hora VALUES (12, '05:30', '19:15');
INSERT INTO hora VALUES (13, '11:20', '12:05');
INSERT INTO hora VALUES (14, '06:45', '21:30');
INSERT INTO hora VALUES (15, '14:55', '15:40');
INSERT INTO hora VALUES (16, '14:35', '17:20');
INSERT INTO hora VALUES (17, '15:10', '18:55');
INSERT INTO hora VALUES (18, '09:45', '20:30');
INSERT INTO hora VALUES (19, '11:20', '22:05');
INSERT INTO hora VALUES (20, '20:50', '23:35');