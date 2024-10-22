CREATE DATABASE bdsancaef;
USE bdsancaef;
CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    rol VARCHAR(50) NOT NULL,
    activo BOOLEAN NOT NULL
);
INSERT INTO usuario (codigo, password, email, rol, activo) VALUES
('usuario1', '$2a$10$C7FhVJ9F8Flb8K6c0.n8oOrA0jI4L9gxQnC6U8z1sQhI10TtI9TP6', 'usuario1@example.com', 'USER', TRUE),
('admin', '$2a$10$C7FhVJ9F8Flb8K6c0.n8oOrA0jI4L9gxQnC6U8z1sQhI10TtI9TP6', 'admin@example.com', 'ADMIN', TRUE);

INSERT INTO usuario (codigo, password, email, rol, activo) VALUES
('sebastian', '$2a$12$51xSZNfAWfnq3Dgees8xBe5UIzVSBcriNxjLhu9VEPqdx2bYrbwli', 'sebastian@example.com', 'USER', TRUE);
DELETE FROM usuario WHERE id = 4;

select * from usuario;