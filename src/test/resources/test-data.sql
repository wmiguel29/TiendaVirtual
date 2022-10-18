BEGIN;
TRUNCATE clientes;

INSERT INTO `clientes` (`idclientes`, `nombre`, `apellio`, `telefono`, `email`)
VALUES
    ('Miguel', 'Wagner', '123456789', '@gmail.com')
    ('Miguel', 'Gaviria', '66666666', '@homtail.com'),
    ('Esteban', 'Garzon', '987654321' '@outlook.com');

COMMIT;