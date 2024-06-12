CREATE DATABASE db_estudiante;
USE db_estudiante;

CREATE TABLE Estudiante(
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150),
    apellido VARCHAR(200),
    email VARCHAR(100),
    f_nacimiento VARCHAR(30)
);

INSERT INTO Estudiante (nombre, apellido, email, f_nacimiento) 
VALUES ('Bernardo', 'Lima', 'email1@gmail.com', '2000-12-05'),
	('María', 'González', 'email2@gmail.com', '1998-03-14'),
	('Carlos', 'Martínez', 'email3@gmail.com', '2001-07-22'),
	('Jackquelin', 'Rodríguez', 'email4@gmail.com', '1999-11-30'),
	('Luis', 'Fernández', 'email5@gmail.com', '2002-05-18');

SELECT * FROM Estudiante;