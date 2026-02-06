-- Insertar Conductores
INSERT INTO conductor (nombre, email) VALUES ('Juan Pérez', 'juan.perez@example.com');
INSERT INTO conductor (nombre, email) VALUES ('María García', 'maria.garcia@example.com');
INSERT INTO conductor (nombre, email) VALUES ('Carlos Rodríguez', 'carlos.rodriguez@example.com');
INSERT INTO conductor (nombre, email) VALUES ('Ana Martínez', 'ana.martinez@example.com');
INSERT INTO conductor (nombre, email) VALUES ('Luis Fernández', 'luis.fernandez@example.com');

-- Insertar Vehículos
INSERT INTO vehiculo (matricula, modelo, km_actuales, estado) VALUES ('1234ABC', 'Ford Transit', 45000, 0);
INSERT INTO vehiculo (matricula, modelo, km_actuales, estado) VALUES ('5678DEF', 'Mercedes Sprinter', 32000, 0);
INSERT INTO vehiculo (matricula, modelo, km_actuales, estado) VALUES ('9012GHI', 'Volkswagen Caddy', 28000, 0);
INSERT INTO vehiculo (matricula, modelo, km_actuales, estado) VALUES ('3456JKL', 'Renault Master', 56000, 0);
INSERT INTO vehiculo (matricula, modelo, km_actuales, estado) VALUES ('7890MNO', 'Peugeot Boxer', 41000, 0);
INSERT INTO vehiculo (matricula, modelo, km_actuales, estado) VALUES ('2468PQR', 'Fiat Ducato', 23000, 1);
INSERT INTO vehiculo (matricula, modelo, km_actuales, estado) VALUES ('1357STU', 'Citroën Jumper', 67000, 2);

-- Insertar Talleres
INSERT INTO taller (nombre, ciudad) VALUES ('Talleres Central', 'Sevilla');
INSERT INTO taller (nombre, ciudad) VALUES ('AutoReparaciones del Sur', 'Málaga');
INSERT INTO taller (nombre, ciudad) VALUES ('Mecánica Rápida', 'Córdoba');
INSERT INTO taller (nombre, ciudad) VALUES ('Taller Express', 'Granada');

-- Insertar Asignaciones (algunas finalizadas, algunas activas)
INSERT INTO asignacion (fecha_inicio, fecha_fin, vehiculo_id, conductor_id) VALUES ('2025-01-15', '2025-02-15', 1, 1);
INSERT INTO asignacion (fecha_inicio, fecha_fin, vehiculo_id, conductor_id) VALUES ('2025-02-01', '2025-03-01', 2, 2);
INSERT INTO asignacion (fecha_inicio, fecha_fin, vehiculo_id, conductor_id) VALUES ('2025-01-20', '2025-02-20', 3, 3);
INSERT INTO asignacion (fecha_inicio, fecha_fin, vehiculo_id, conductor_id) VALUES ('2025-02-10', '2025-03-10', 4, 4);
INSERT INTO asignacion (fecha_inicio, fecha_fin, vehiculo_id, conductor_id) VALUES ('2025-01-10', NULL, 6, 5);

-- Insertar Mantenimientos
INSERT INTO mantenimiento (tipo, fecha, km_en_revision, vehiculo_id, taller_id) VALUES ('Cambio de aceite', '2025-01-05', 40000, 1, 1);
INSERT INTO mantenimiento (tipo, fecha, km_en_revision, vehiculo_id, taller_id) VALUES ('Revisión de frenos', '2025-01-12', 30000, 2, 2);
INSERT INTO mantenimiento (tipo, fecha, km_en_revision, vehiculo_id, taller_id) VALUES ('Cambio de neumáticos', '2025-01-18', 25000, 3, 1);
INSERT INTO mantenimiento (tipo, fecha, km_en_revision, vehiculo_id, taller_id) VALUES ('Revisión general', '2025-01-25', 50000, 4, 3);
INSERT INTO mantenimiento (tipo, fecha, km_en_revision, vehiculo_id, taller_id) VALUES ('Reparación motor', '2025-02-01', 65000, 7, 4);
INSERT INTO mantenimiento (tipo, fecha, km_en_revision, vehiculo_id, taller_id) VALUES ('Cambio de filtros', '2025-02-05', 38000, 5, 2);

