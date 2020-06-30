CREATE TABLE ubigeo (
  CODUBI char(6) NOT NULL,
  NOMDEP varchar(255),
  NOMPROV varchar(255),
  NOMDIST varchar(255),
  PRIMARY KEY ( CODUBI )
);


INSERT INTO ubigeo (CODUBI, NOMDEP, NOMPROV, NOMDIST) VALUES
('150501', 'Lima', 'Cañete', 'San Vicente de Cañete'),
('150502', 'Lima', 'Cañete', 'Asia'),
('150503', 'Lima', 'Cañete', 'Calango'),
('150504', 'Lima', 'Cañete', 'Cerro Azul'),
('150505', 'Lima', 'Cañete', 'Chilca'),
('150506', 'Lima', 'Cañete', 'Coayllo'),
('150507', 'Lima', 'Cañete', 'Imperial'),
('150508', 'Lima', 'Cañete', 'Lunahuana'),
('150509', 'Lima', 'Cañete', 'Mala'),
('150510', 'Lima', 'Cañete', 'Nuevo Imperial'),
('150511', 'Lima', 'Cañete', 'Pacaran'),
('150512', 'Lima', 'Cañete', 'Quilmana'),
('150513', 'Lima', 'Cañete', 'San Antonio'),
('150514', 'Lima', 'Cañete', 'San Luis'),
('150515', 'Lima', 'Cañete', 'Santa Cruz de Flores'),
('150516', 'Lima', 'Cañete', 'Zúñiga');


CREATE TABLE persona(
    IDPER int AUTO_INCREMENT,
	NOMPER varchar(100),
    APEPER varchar(100),
    CODUBI char(6),
    PRIMARY KEY (IDPER),
    FOREIGN KEY (CODUBI) REFERENCES ubigeo(CODUBI)
);

INSERT INTO persona (NOMPER, APEPER, CODUBI) VALUES
('Jose', 'Luis', '150501');

