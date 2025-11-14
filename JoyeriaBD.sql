create database JoyeriaBD;
use JoyeriaBD;

INSERT INTO roles (nombre) VALUES ('USUARIO');
INSERT INTO roles (nombre) VALUES ('ADMINISTRADOR');

INSERT INTO categorias VALUES (1, 'Oro', 1);
INSERT INTO categorias VALUES (2, 'Diamantes', 1);

select * from roles;
select * from usuario;
select * from usuario_rol;