-- Crear base de datos
CREATE DATABASE IF NOT EXISTS soporte_logistica_db;
USE soporte_logistica_db;

-- Tabla: incidencia
CREATE TABLE IF NOT EXISTS incidencia (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    fecha_reporte VARCHAR(50)
);

-- Tabla: proveedor
CREATE TABLE IF NOT EXISTS proveedor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    contacto VARCHAR(100),
    servicio VARCHAR(100)
);

-- Inserciones de ejemplo
INSERT INTO proveedor (nombre, contacto, servicio) VALUES
('TechCorp', 'techcorp@correo.com', 'Soporte de hardware'),
('LogistiPro', 'logisti@correo.com', 'Distribución y logística');

INSERT INTO incidencia (descripcion, estado, fecha_reporte) VALUES
('Servidor caído en sede central', 'PENDIENTE', '2025-05-24'),
('Pantalla defectuosa en aula 3', 'EN_PROGRESO', '2025-05-23');
