USE master
GO
IF EXISTS
(
	SELECT name
	FROM sysdatabases
	WHERE name='POO'
)
DROP DATABASE POO
GO
CREATE DATABASE POO
ON PRIMARY
(
	NAME='POO_dat',
	FILENAME='D:\db\POO_dat.mdf',
	SIZE=30MB,
	MAXSIZE=50MB,
	FILEGROWTH=10MB
)
LOG ON
(
	NAME='POO_log',
	FILENAME='D:\db\POO_log.ldf',
	SIZE=10MB,
	MAXSIZE=UNLIMITED,
	FILEGROWTH=10%
)
USE POO
GO
---TABLA EMPLEADOS---
IF EXISTS
(
	SELECT name
	FROM  sys.tables
	WHERE name='EMPLEADOS'
)
DROP TABLE EMPLEADOS
GO
CREATE TABLE EMPLEADOS(
APELLIDO VARCHAR(50) NOT NULL,
NOMBRE VARCHAR(50) NOT NULL,
FECHANAC DATE NOT NULL,
DNI VARCHAR(8) NOT NULL,
DIRECCION VARCHAR(50) NOT NULL,
TELEFONO VARCHAR(10) NOT NULL
PRIMARY KEY(DNI)
)
GO
---TABLA LABORES---
IF EXISTS
(
	SELECT name
	FROM  sys.tables
	WHERE name='LABORES'
)
DROP TABLE LABORES
GO
CREATE TABLE LABORES(
CARGO VARCHAR(50) NOT NULL,
);
GO
---TABLA HORARIO---
IF EXISTS
(
	SELECT name
	FROM  sys.tables
	WHERE name='HORARIO'
)
DROP TABLE HORARIO
GO
CREATE TABLE HORARIO(
HORA_INGRESO VARCHAR(20) NOT NULL,
HORA_SALIDA VARCHAR(20) NOT NULL,
HORA_REFRIGRERIO VARCHAR(20) NOT NULL,
FIN_REFRIGERIO VARCHAR(20) NOT NULL,
)
GO
---TABLA PERMISOS---
IF EXISTS
(
	SELECT name
	FROM  sys.tables
	WHERE name='PERMISOS'
)
DROP TABLE PERMISOS
GO
CREATE TABLE PERMISOS(
FECHA_PERMISO DATE NOT NULL,
TIEMPO VARCHAR(20) NOT NULL,
DESCRIPCION VARCHAR(100),
);
GO
--TABLA DE ASISTENCIA
IF EXISTS
(
	SELECT name
	FROM  sys.tables
	WHERE name='ASISTENCIA'
)
DROP TABLE ASISTENCIA
GO
CREATE TABLE ASISTENCIA(
MARCACION VARCHAR(50)NOT NULL,
HORA TIME NOT NULL,
FECHA DATE NOT NULL,
)
GO
 
ALTER TABLE LABORES ADD DNI VARCHAR(8) NULL 
CONSTRAINT FK_LABORES_EMPLEADOS_DNI
FOREIGN  KEY(DNI) REFERENCES EMPLEADOS(DNI);

ALTER TABLE HORARIO ADD DNI VARCHAR(8) NULL 
CONSTRAINT FK_HORARIO_EMPLEADOS_DNI
FOREIGN  KEY(DNI) REFERENCES EMPLEADOS(DNI);

ALTER TABLE PERMISOS ADD DNI VARCHAR(8) NULL 
CONSTRAINT FK_PERMISOS_EMPLEADOS_DNI
FOREIGN  KEY(DNI) REFERENCES EMPLEADOS(DNI);

ALTER TABLE ASISTENCIA ADD DNI VARCHAR(8)NOT NULL
CONSTRAINT FK_ASISTENCIA_EMPLEADOS_DNI
FOREIGN KEY(DNI) REFERENCES EMPLEADOS(DNI);

---CONSULTAS---
SELECT EMPLEADOS.APELLIDO, EMPLEADOS.NOMBRE, LABORES.DNI, LABORES.CARGO FROM EMPLEADOS INNER JOIN LABORES ON EMPLEADOS.DNI=LABORES.DNI; 
SELECT EMPLEADOS.APELLIDO, EMPLEADOS.NOMBRE, HORARIO.DNI,HORARIO.HORA_INGRESO,HORARIO.HORA_SALIDA,HORARIO.HORA_REFRIGRERIO,HORARIO.FIN_REFRIGERIO FROM EMPLEADOS INNER JOIN HORARIO ON EMPLEADOS.DNI=HORARIO.DNI;
SELECT EMPLEADOS.APELLIDO, EMPLEADOS.NOMBRE, PERMISOS.DNI,PERMISOS.FECHA_PERMISO,PERMISOS.TIEMPO,PERMISOS.DESCRIPCION FROM EMPLEADOS INNER JOIN PERMISOS ON EMPLEADOS.DNI=PERMISOS.DNI;
SELECT EMPLEADOS.APELLIDO, EMPLEADOS.NOMBRE, ASISTENCIA.DNI, ASISTENCIA.FECHA,ASISTENCIA.HORA,ASISTENCIA.MARCACION FROM EMPLEADOS INNER JOIN ASISTENCIA ON EMPLEADOS.DNI=ASISTENCIA.DNI;

---CREATE---
INSERT INTO EMPLEADOS(APELLIDO,NOMBRE,FECHANAC,DNI,DIRECCION,TELEFONO) VALUES('Alvarado Mendoza','Oscar','17/07/1995','72064196','Jr.Cusco','5719791');
INSERT INTO EMPLEADOS(APELLIDO,NOMBRE,FECHANAC,DNI,DIRECCION,TELEFONO) VALUES('Alvarado Mendoza','Oscar','17/07/1995','76644477','Jr.Cusco','5719791');
INSERT INTO LABORES (CARGO,DNI) VALUES ('ADMINISTRADOR','72064196');
INSERT INTO HORARIO(HORA_INGRESO,HORA_SALIDA,HORA_REFRIGRERIO,FIN_REFRIGERIO,DNI) VALUES('8:00 AM','6:00 PM','1:00 PM','2:00 PM','72064196');
INSERT INTO PERMISOS(FECHA_PERMISO,TIEMPO,DESCRIPCION,DNI)VALUES('12/11/2019','1 DIA','DESCANSO MEDICO','72064196');
INSERT INTO ASISTENCIA(MARCACION,HORA,FECHA,DNI) VALUES ('ENTRADA','2:20:08','06/09/2019','72064196');

---READ---
SELECT APELLIDO,NOMBRE,FECHANAC,DNI,DIRECCION,TELEFONO FROM EMPLEADOS WHERE DNI='72064196';
SELECT  DNI, CARGO FROM LABORES  WHERE DNI='72882822';
SELECT DNI,FECHA_PERMISO, TIEMPO,DESCRIPCION FROM PERMISOS WHERE DNI='72064196';
SELECT DNI,HORA_INGRESO,HORA_SALIDA,HORA_REFRIGRERIO,FIN_REFRIGERIO FROM HORARIO WHERE DNI='72882822';
SELECT DNI,MARCACION,HORA,FECHA FROM ASISTENCIA WHERE DNI='72064196';

---UPDATE----
UPDATE EMPLEADOS SET APELLIDO='ALVARADO MENDOZA', NOMBRE='JUAN',FECHANAC='17/08/1995',DNI='72064196',DIRECCION='Jr.Cusco',TELEFONO='5719791' WHERE DNI='72064196';
UPDATE LABORES SET DNI='72882822', CARGO='ADMINISTRADOR' WHERE DNI='72882822';
UPDATE PERMISOS SET DNI='72064196',FECHA_PERMISO= '12/11/2019', TIEMPO='2 DIA', DESCRIPCION='DESCANSO MEDICO' WHERE DNI='72064196'; 
UPDATE HORARIO SET DNI='72064196',HORA_INGRESO='8:00 AM',HORA_SALIDA='1:00 PM',HORA_REFRIGRERIO='2:00 PM',FIN_REFRIGERIO='72064196' WHERE DNI='72064196';
UPDATE ASISTENCIA SET DNI='72064196',MARCACION='ENTRADA',HORA='02:20:08.0000000', FECHA='13/09/2019' WHERE DNI='72064196';
	
							--('8:00 AM','6:00 PM','1:00 PM','2:00 PM','72064196');
---DELETE---
DELETE FROM EMPLEADOS WHERE DNI='73755441';
DELETE FROM LABORES WHERE DNI='8659600';
DELETE FROM PERMISOS WHERE DNI='72064196';
DELETE FROM ASISTENCIA WHERE DNI='72064196';


DELETE FROM EMPLEADOS
DELETE FROM LABORES
DELETE FROM PERMISOS
DELETE FROM ASISTENCIA
DELETE FROM HORARIO

SELECT*FROM EMPLEADOS
SELECT*FROM LABORES
SELECT*FROM HORARIO
SELECT*FROM PERMISOS
SELECT*FROM ASISTENCIA


---REPORTE POR EMPLEADO---
SELECT EMPLEADOS.APELLIDO, EMPLEADOS.NOMBRE, EMPLEADOS.DNI, EMPLEADOS.FECHANAC, EMPLEADOS.DIRECCION, EMPLEADOS.TELEFONO,
       LABORES.CARGO,
	   PERMISOS.FECHA_PERMISO, PERMISOS.TIEMPO, PERMISOS.DESCRIPCION,
	   ASISTENCIA.FECHA, ASISTENCIA.HORA, ASISTENCIA.MARCACION
FROM EMPLEADOS,LABORES,PERMISOS,ASISTENCIA
WHERE EMPLEADOS.DNI=LABORES.DNI AND
      EMPLEADOS.DNI=PERMISOS.DNI AND
      EMPLEADOS.DNI=ASISTENCIA.DNI AND
	  EMPLEADOS.DNI='73755441';


