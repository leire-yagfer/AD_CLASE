drop
database if exists UsuariosGrupos;
CREATE
DATABASE UsuariosGrupos;
use
UsuariosGrupos;
CREATE TABLE usuarios
(
    user_id  integer     NOT NULL AUTO_INCREMENT,
    username varchar(45) NOT NULL,
    password varchar(45) NOT NULL,
    email    varchar(45) NOT NULL,
    PRIMARY KEY (user_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

INSERT INTO usuarios (username, password, email)
VALUES ('Julian', 'Julian', 'Julian@gmail.com'),
       ('Rosa', 'Rosa', 'Rosa@gmail.com'),
       ('Vicente', 'Vicente', 'Vicente@gmail.com');




CREATE TABLE grupos
(
    group_id integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name     varchar(45)         NOT NULL

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
INSERT INTO grupos (name)
VALUES ('Fontaneros'),
       ('Abogados'),
       ('Dependientes');



CREATE TABLE usuarios_grupos
(
    user_group_id integer NOT NULL AUTO_INCREMENT,
    user_id       integer NOT NULL,
    group_id      integer NOT NULL,
    cuota         integer NOT NULL,
    PRIMARY KEY (user_group_id),
    KEY           fk_user (user_id),
    KEY           fk_group (group_id),
    CONSTRAINT fk_group FOREIGN KEY (group_id) REFERENCES grupos (group_id)
        ON delete CASCADE
        ON update CASCADE,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES usuarios (user_id)
        ON delete CASCADE
        ON update CASCADE
);
