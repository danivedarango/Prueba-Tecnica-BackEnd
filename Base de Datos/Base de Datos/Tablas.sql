CREATE TABLE Empleado (
    employee_id NUMBER,
    first_name VARCHAR2(50),
    last_name VARCHAR2(50),
    curp VARCHAR2(18),
    puesto VARCHAR2(50),
    jefe_inmediato_id NUMBER,
    direccion_id NUMBER,
    clave_unica VARCHAR2(18),
    CONSTRAINT Empleado_PK PRIMARY KEY(employee_id),
    CONSTRAINT fk_jefe FOREIGN KEY (jefe_inmediato_id) REFERENCES Empleado(employee_id),
    CONSTRAINT fk_direccion FOREIGN KEY (direccion_id) REFERENCES Direccion(direccion_id)
);

CREATE TABLE Direccion (
    direccion_id NUMBER,
    calle VARCHAR2(100),
    no_exterior VARCHAR2(10),
    no_interior VARCHAR2(10),
    colonia VARCHAR2(50),
    municipio VARCHAR2(50),
    estado VARCHAR2(50),
    pais VARCHAR2(50),
    CONSTRAINT Direccion_PK PRIMARY KEY(direccion_id)
);

INSERT INTO Direccion VALUES (1, 'Av. Zaragoza', '1237', '2', 'Centro', 'CDMX', 'CDMX', 'Mexico');
INSERT INTO Direccion VALUES (2, 'Calle Juarez', '1526', '4', 'Centro', 'Puebla', 'Puebla', 'Mexico');

INSERT INTO Empleado VALUES (1, 'Juan', 'Perez', 'JUAP123456MNEXR1', 'Gerente', NULL, 1, 'JUAP123456MNEXR1');
INSERT INTO Empleado VALUES (2, 'Maria', 'Hernandez', 'MAHE190896MNLLL076', 'Programadora', 1, 2, 'MAHE190896MNLLL076');

SELECT * FROM Direccion;
SELECT * FROM Empleado;
