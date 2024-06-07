-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS club_nautico;
USE club_nautico;

-- Crear la tabla Sociosalida
CREATE TABLE IF NOT EXISTS `socio` (
    `socio_dni` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `nombre` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `apellido` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    PRIMARY KEY (`socio_dni`) USING BTREE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;

-- Crear la tabla Patron con una clave foránea a Socio
CREATE TABLE IF NOT EXISTS `patron` (
    `id_patron` INT AUTO_INCREMENT,
    `nombre` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `apellido` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `socio_dni` VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    PRIMARY KEY (`id_patron`) USING BTREE,
    CONSTRAINT `patron_ibfk_1` FOREIGN KEY (`socio_dni`) REFERENCES `socio` (`socio_dni`) ON UPDATE CASCADE ON DELETE CASCADE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;

-- Crear la tabla Barco
CREATE TABLE IF NOT EXISTS `barco` (
    `matricula` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `nombre` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `amarre` VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `cuota` DOUBLE NOT NULL,
    `socio_dni` VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    PRIMARY KEY (`matricula`) USING BTREE,
    INDEX `socio_dni` (`socio_dni`) USING BTREE,
    CONSTRAINT `barco_ibfk_1` FOREIGN KEY (`socio_dni`) REFERENCES `socio` (`socio_dni`) ON UPDATE CASCADE ON DELETE CASCADE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;

-- Crear la tabla Salida con datos de patrón y barco
CREATE TABLE IF NOT EXISTS `salida` (
    `id_salida` INT(10) NOT NULL AUTO_INCREMENT,
    `fecha_hora` DATETIME NULL DEFAULT NULL,
    `destino` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `barco_matricula` VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `id_patron` INT NULL DEFAULT NULL,
    PRIMARY KEY (`id_salida`) USING BTREE,
    INDEX `barco_matricula` (`barco_matricula`) USING BTREE,
    INDEX `id_patron` (`id_patron`) USING BTREE,
    CONSTRAINT `salida_ibfk_1` FOREIGN KEY (`barco_matricula`) REFERENCES `barco` (`matricula`) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT `salida_ibfk_2` FOREIGN KEY (`id_patron`) REFERENCES `patron` (`id_patron`) ON UPDATE CASCADE ON DELETE CASCADE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1;

-- Insertar datos en la tabla Socio
INSERT INTO `socio` (`socio_dni`, `nombre`, `apellido`) VALUES
('12345678A', 'Juan', 'Pérez'),
('87654321B', 'María', 'García'),
('45678901C', 'Pedro', 'Martínez'),
('78901234D', 'Laura', 'López'),
('23456789E', 'Carlos', 'Rodríguez');

-- Insertar datos en la tabla Patron
INSERT INTO `patron` (`nombre`, `apellido`, `socio_dni`) VALUES
('Juan', 'Pérez', '12345678A'),
('María', 'García', '87654321B'),
('Pedro', 'Martínez', '45678901C'),
('Laura', 'López', '78901234D'),
('Carlos', 'Rodríguez', '23456789E');

-- Insertar datos en la tabla Barco
INSERT INTO `barco` (`matricula`, `nombre`, `amarre`, `cuota`, `socio_dni`) VALUES
('123ABC', 'Martirio', 'A01', 200.00, '12345678A'),
('456DEF', 'Oceanico', 'B05', 150.00, '87654321B'),
('789GHI', 'Sailor', 'C10', 180.00, '45678901C'),
('987JKL', 'SurfeadorOlas', 'D15', 220.00, '78901234D'),
('543MNO', 'InterMarino', 'E20', 190.00, '23456789E');

-- Insertar datos en la tabla Salida con datos de patrón
INSERT INTO `salida` (`fecha_hora`, `destino`, `barco_matricula`, `id_patron`) VALUES
('2024-05-01 10:00:00', 'Ibiza', '123ABC', 1),
('2024-05-02 09:30:00', 'Formentera', '456DEF', 2),
('2024-05-03 11:15:00', 'Mallorca', '789GHI', 3),
('2024-05-04 12:00:00', 'Menorca', '987JKL', 4),
('2024-05-05 14:30:00', 'Tenerife', '543MNO', 5);
