-- ELECTRÓNICA (variedad de precios y stocks)
INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Televisor Samsung 55"', 'Smart TV 4K UHD con HDR y sistema Tizen. Pantalla QLED de 55 pulgadas con resolución 3840x2160', 599.99, 10, 'ELECTRONICA', true, '2024-10-01');

INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Auriculares Sony WH-1000XM5', 'Auriculares Bluetooth premium con cancelación activa de ruido y 30h de batería', 89.90, 50, 'ELECTRONICA', true, '2024-09-15');

INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Portátil Lenovo Legion 5', 'Portátil gaming con Intel i7-13700H, 16GB RAM DDR5, RTX 4060 8GB, SSD 1TB NVMe', 1499.00, 5, 'ELECTRONICA', false, '2024-08-20');

INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Ratón Logitech MX Master 3S', 'Ratón inalámbrico ergonómico con 8000 DPI, conexión Bluetooth y receptor USB', 19.99, 0, 'ELECTRONICA', true, '2024-11-05');

INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Teclado mecánico Keychron K2', 'Teclado mecánico wireless con switches Gateron Brown, retroiluminación RGB', 79.00, 25, 'ELECTRONICA', true, '2025-01-10');

INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Tablet iPad Air M2', 'Tablet Apple con chip M2, pantalla Liquid Retina de 11 pulgadas, 128GB', 649.00, 8, 'ELECTRONICA', true, '2024-12-05');

-- ROPA (diferentes rangos de precio)
INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Camiseta básica algodón', 'Camiseta de algodón 100% orgánico, disponible en varios colores, talla M', 9.99, 100, 'ROPA', true, '2024-07-10');

INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Sudadera con capucha Nike', 'Sudadera unisex con capucha y bolsillo canguro, tejido French Terry', 29.95, 25, 'ROPA', true, '2024-06-01');

INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Pantalón vaquero Levi''s 501', 'Vaquero clásico slim fit, denim stretch con lavado azul medio', 39.90, 5, 'ROPA', false, '2024-05-18');

INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Zapatillas Adidas Ultraboost', 'Zapatillas running con tecnología Boost y suela Continental, talla 42', 149.99, 15, 'ROPA', true, '2025-01-15');

-- HOGAR (productos variados)
INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Lámpara de escritorio LED', 'Lámpara LED regulable con brazo flexible, 3 modos de iluminación y puerto USB', 24.50, 30, 'HOGAR', true, '2024-03-22');

INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Sartén Tefal Ingenio', 'Sartén antiadherente de 28cm compatible con inducción, mango desmontable', 34.99, 15, 'HOGAR', true, '2024-02-14');

INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Set de cuchillos Arcos', 'Juego de 5 cuchillos profesionales de acero inoxidable con taco de bambú', 49.90, 3, 'HOGAR', false, '2024-01-05');

INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Aspiradora Roomba i3', 'Robot aspirador inteligente con navegación por filas, WiFi y app móvil', 299.00, 7, 'HOGAR', true, '2024-11-20');

INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Cafetera Nespresso Vertuo', 'Cafetera de cápsulas con sistema Centrifusion, depósito 1.7L', 129.00, 20, 'HOGAR', true, '2024-10-12');

-- DEPORTES (para probar filtros)
INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Balón fútbol Adidas UCL', 'Balón oficial Champions League, tamaño 5 con tecnología TSBE', 19.95, 40, 'DEPORTES', true, '2023-12-01');

INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Zapatillas Nike Pegasus 40', 'Zapatillas running con amortiguación React y Air Zoom, talla 42', 69.90, 8, 'DEPORTES', true, '2023-11-11');

INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Mancuernas 5kg Domyos', 'Par de mancuernas hexagonales de 5kg con recubrimiento de neopreno', 39.99, 0, 'DEPORTES', false, '2023-10-20');

INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Bicicleta estática Cecotec', 'Bicicleta indoor con volante de inercia 24kg, monitor LCD y freno magnético', 249.00, 4, 'DEPORTES', true, '2024-09-05');

-- JUGUETES (stock variado para probar paginación)
INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Coche RC Ferrari F40', 'Coche teledirigido escala 1:14 con batería recargable y mando 2.4GHz', 44.90, 12, 'JUGUETES', true, '2023-09-09');

INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('LEGO Creator 3 en 1', 'Set de construcción con 200 piezas, incluye 3 modelos diferentes', 29.99, 60, 'JUGUETES', true, '2023-08-08');

INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Muñeca Barbie Fashionista', 'Muñeca articulada con ropa y accesorios incluidos', 24.99, 4, 'JUGUETES', false, '2023-07-07');

INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Puzzle Ravensburger 1000 piezas', 'Puzzle panorámico de paisajes europeos con calidad premium', 14.95, 35, 'JUGUETES', true, '2024-04-15');

INSERT INTO productos (nombre, descripcion, precio, stock, categoria, disponible, fecha_alta) VALUES ('Peluche Pokemon Pikachu', 'Peluche oficial de Pikachu, 30cm de altura, tejido suave', 19.90, 50, 'JUGUETES', true, '2024-06-20');
