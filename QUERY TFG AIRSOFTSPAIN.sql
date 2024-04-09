CREATE DATABASE IF NOT EXISTS airsoftspain;
USE airsoftspain;

CREATE TABLE usuarios (
    id_user INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    DNI VARCHAR(20) NOT NULL,
    nombre VARCHAR(50),
    apellidos VARCHAR(100),
    CPostal INTEGER,
    direccion VARCHAR(150),
    id_rol INTEGER,
    email VARCHAR(100),
    telefono VARCHAR(20),
    contraseña VARCHAR(50)
);

CREATE TABLE rol (
    id_rol INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    descripcion VARCHAR(150)
);

CREATE TABLE rol_usuarios (
    id_user INTEGER,
    id_rol INTEGER,
    FOREIGN KEY (id_user) REFERENCES usuarios (id_user),
    FOREIGN KEY (id_rol) REFERENCES rol (id_rol)
);

CREATE TABLE etiquetas (
    id_etiqueta INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50)
);

CREATE TABLE tipo_producto (
    id_tipo_producto INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombre_tipo VARCHAR(100),
    descripcion VARCHAR(200)
);

CREATE TABLE productos (
    id_producto INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombre_producto VARCHAR(150),
    descripcion VARCHAR(300),
    etiquetas INTEGER(3),
    precio DECIMAL(10,2),
    stock INTEGER,
    tipo_producto_id INTEGER,
    FOREIGN KEY (tipo_producto_id) REFERENCES tipo_producto (id_tipo_producto)
);

CREATE TABLE productos_etiquetas (
    id_producto INTEGER,
    id_etiqueta INTEGER,
    PRIMARY KEY (id_producto, id_etiqueta),
    FOREIGN KEY (id_producto) REFERENCES productos (id_producto),
    FOREIGN KEY (id_etiqueta) REFERENCES etiquetas (id_etiqueta)
);

CREATE TABLE pedidos (
    id_pedido INTEGER PRIMARY KEY AUTO_INCREMENT,
    precio_total DECIMAL(10,2)
);

INSERT INTO usuarios (DNI, nombre, apellidos, CPostal, direccion, id_rol, email, telefono, contraseña)
VALUES
('12345678A', 'Juan', 'Pérez', 28001, 'Calle Mayor 1', 1, 'juan@example.com', '123456789', 'password1'),
('98765432B', 'María', 'González', 28002, 'Calle Estrella 2', 2, 'maria@example.com', '987654321', 'password2'),
('45678912C', 'Pedro', 'Martínez', 28003, 'Calle Sol 3', 1, 'pedro@example.com', '456789123', 'password3'),
('78912345D', 'Laura', 'Sánchez', 28004, 'Calle Luna 4', 2, 'laura@example.com', '789123456', 'password4'),
('32165498E', 'Ana', 'López', 28005, 'Calle Río 5', 1, 'ana@example.com', '321654987', 'password5'),
('65498732F', 'David', 'Fernández', 28006, 'Calle Monte 6', 2, 'david@example.com', '654987321', 'password6'),
('85296374G', 'Sara', 'Rodríguez', 28007, 'Calle Mar 7', 1, 'sara@example.com', '852963741', 'password7'),
('14725836H', 'Carlos', 'Ruiz', 28008, 'Calle Pino 8', 2, 'carlos@example.com', '147258369', 'password8'),
('36985214I', 'Elena', 'García', 28009, 'Calle Palmera 9', 1, 'elena@example.com', '369852147', 'password9'),
('25814736J', 'Miguel', 'Díaz', 28010, 'Calle Olivo 10', 2, 'miguel@example.com', '258147369', 'password10');


