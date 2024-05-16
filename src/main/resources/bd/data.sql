
IF NOT EXISTS
(SELECT 1 FROM evento WHERE evento_id = 1 AND evento_nombre = 'Adviento')
BEGIN
INSERT evento (evento_id, evento_nombre) VALUES (1, 'Adviento')
END

IF NOT EXISTS
    (SELECT 1 FROM evento WHERE evento_id = 2 AND evento_nombre = 'Tiempo de Navidad')
BEGIN
        INSERT evento (evento_id, evento_nombre) VALUES (2, 'Tiempo de Navidad')
END;

IF NOT EXISTS
    (SELECT 1 FROM evento WHERE evento_id = 3 AND evento_nombre = 'Año Nuevo')
BEGIN
        INSERT evento (evento_id, evento_nombre) VALUES (3, 'Año Nuevo')
END;

IF NOT EXISTS
    (SELECT 1 FROM detalle WHERE detalle_id = 1 AND detalle_nombre = 'Misterio de Navidad')
BEGIN
        INSERT detalle (detalle_id, detalle_nombre) VALUES (1, 'Misterio de Navidad')
END;

IF NOT EXISTS
    (SELECT 1 FROM detalle WHERE detalle_id = 2 AND detalle_nombre = 'La fiesta Sagrada de los Santos Inocentes')
BEGIN
        INSERT detalle (detalle_id, detalle_nombre) VALUES (2, 'La fiesta Sagrada de los Santos Inocentes')
END;

IF NOT EXISTS
    (SELECT 1 FROM detalle WHERE detalle_id = 3 AND detalle_nombre = 'Agradecimiento y reflexión de conciencia')
BEGIN
        INSERT detalle (detalle_id, detalle_nombre) VALUES (3, 'Agradecimiento y reflexión de conciencia')
END;


IF NOT EXISTS
    (SELECT 1 FROM usuario WHERE id = 1)
BEGIN
        INSERT usuario (id,password,username) VALUES(1,'$2a$04$I6aCuSlNfFonKN44nE4Hr.yTpK0p6jSypWj7faX7AYdFfcMxlfg5G','admin') -- password: 1234
END;
IF NOT EXISTS
    (SELECT 1 FROM usuario WHERE id = 2)
BEGIN
        INSERT usuario (id,password,username) VALUES(2,'$2a$04$bU7JceNofKgQErmZy3T6cOhUARTapKzj3Fbx5NbFhNgNiRvVW6vL6','user') -- password: 1234
END;
IF NOT EXISTS
    (SELECT 1 FROM authority WHERE id = 1)
BEGIN
        INSERT authority (id,authority) VALUES (1,'ROLE_ADMIN')
END;
IF NOT EXISTS
    (SELECT 1 FROM authority WHERE id = 2)
BEGIN
        INSERT authority (id,authority) VALUES (2,'ROLE_USER')
END;
IF NOT EXISTS
    (SELECT 1 FROM authorities_users WHERE usuario_id = 1 AND authority_id = 1)
BEGIN
        INSERT authorities_users (usuario_id, authority_id) VALUES (1,1)
END;
IF NOT EXISTS
    (SELECT 1 FROM authorities_users WHERE usuario_id = 1 AND authority_id = 2)
BEGIN
        INSERT authorities_users (usuario_id, authority_id) VALUES (1,2)
END;
IF NOT EXISTS
    (SELECT 1 FROM authorities_users WHERE usuario_id = 2 AND authority_id = 2)
BEGIN
        INSERT authorities_users (usuario_id, authority_id) VALUES (2,2)
END;