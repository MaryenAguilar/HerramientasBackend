create database JoyeriaBD;
drop database JoyeriaBD;
use JoyeriaBD;
/*Solo ingresar los roles y categorias*/
INSERT INTO roles (nombre) VALUES ('USUARIO');

/*Categorias de prueba, no sera la final*/
INSERT INTO categorias (id_categoria, descripcion, estado) VALUES
(6, 'Bolsas Reutilizables', 1),
(7, 'Artículos Compostables', 1),
(3, 'Limpieza Ecológica', 1),
(4, 'Productos de Higiene Natural', 1),
(5, 'Accesorios Eco-Amigables', 1);

select * from roles;
select * from usuario;
select * from usuario_rol;
select * from reclamos;
select * from pedido;
select * from pedido_item;