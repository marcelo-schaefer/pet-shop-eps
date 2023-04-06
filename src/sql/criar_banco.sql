CREATE TABLE IF NOT EXISTS especie
(
    id   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255)    NOT NULL
);

CREATE TABLE IF NOT EXISTS animal
(
    id              INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome            VARCHAR(255)    NOT NULL,
    data_nascimento DATE            NOT NULL,
    sexo            VARCHAR(12)     NOT NULL,
    ativo           TINYINT         NOT NULL,
    especie_id      INT             NOT NULL,
    CONSTRAINT "fk_animal_especie"
        FOREIGN KEY ("especie_id")
            REFERENCES "especie" ("id")
);

CREATE TABLE IF NOT EXISTS cliente
(
    id              INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome            VARCHAR(255)    NOT NULL,
    cpf             VARCHAR(14)     NOT NULL,
    data_nascimento DATE            NOT NULL,
    ativo           TINYINT         NOT NULL
);

CREATE TABLE IF NOT EXISTS consulta
(
    id         INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome       VARCHAR(255)    NOT NULL,
    observacao VARCHAR(500)    NOT NULL,
    horario    DATETIME        NOT NULL,
    cliente_id INT             NOT NULL,
    animal_id  INT             NOT NULl,
    CONSTRAINT "fk_consulta_cliente"
        FOREIGN KEY ("cliente_id")
            REFERENCES "cliente" ("id")
);