create table if not exists animal
(
    id              int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome            varchar(255)    NOT NULL,
    data_nascimento DATE            NOT NULL,
    sexo            varchar(12)     NOT NULL,
    ativo           tinyint         NOT NULL
);