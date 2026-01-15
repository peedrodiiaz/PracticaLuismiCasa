-- Profesionales
INSERT INTO profesional (id, nombre, especialidad) VALUES (1, 'Dr. Juan Pérez', 'Cardiología');
INSERT INTO profesional (id, nombre, especialidad) VALUES (2, 'Dra. Ana López', 'Dermatología');
INSERT INTO profesional (id, nombre, especialidad) VALUES (3, 'Dr. Carlos Ruiz', 'Pediatría');

-- Pacientes
INSERT INTO paciente (id, nombre, email, fecha_nacimiento) VALUES (1, 'María García', 'maria.garcia@email.com', '1985-04-12');
INSERT INTO paciente (id, nombre, email, fecha_nacimiento) VALUES (2, 'Pedro Sánchez', 'pedro.sanchez@email.com', '1990-09-23');
INSERT INTO paciente (id, nombre, email, fecha_nacimiento) VALUES (3, 'Lucía Fernández', 'lucia.fernandez@email.com', '1978-12-05');
INSERT INTO paciente (id, nombre, email, fecha_nacimiento) VALUES (4, 'Javier Torres', 'javier.torres@email.com', '2000-07-15');
INSERT INTO paciente (id, nombre, email, fecha_nacimiento) VALUES (5, 'Elena Martín', 'elena.martin@email.com', '1995-02-28');

-- Citas PROGRAMADAS (sin consulta) - Estado: 0 = PROGRAMADA
INSERT INTO cita (id, fecha_hora, estado, paciente_id, profesional_id) VALUES (1, '2026-02-15 10:00:00', 0, 1, 1);
INSERT INTO cita (id, fecha_hora, estado, paciente_id, profesional_id) VALUES (2, '2026-02-16 11:30:00', 0, 2, 2);
INSERT INTO cita (id, fecha_hora, estado, paciente_id, profesional_id) VALUES (3, '2026-02-17 09:00:00', 0, 3, 1);
INSERT INTO cita (id, fecha_hora, estado, paciente_id, profesional_id) VALUES (4, '2026-02-18 12:00:00', 0, 4, 3);
INSERT INTO cita (id, fecha_hora, estado, paciente_id, profesional_id) VALUES (5, '2026-02-19 08:30:00', 0, 5, 2);
