CREATE DATABASE pet_shop;

CREATE TABLE IF NOT EXISTS pet_shop.especie
(
    id   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255)    NOT NULL
);

CREATE TABLE IF NOT EXISTS pet_shop.animal
(
    id              INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome            VARCHAR(255)    NOT NULL,
    detalhe         VARCHAR(500),
    data_nascimento DATE            NOT NULL,
    sexo            VARCHAR(12)     NOT NULL,
    ativo           TINYINT         NOT NULL,
    especie_id      INT             NOT NULL
);

CREATE TABLE IF NOT EXISTS pet_shop.cliente
(
    id              INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome            VARCHAR(255)    NOT NULL,
    cpf             VARCHAR(14)     NOT NULL,
    data_nascimento DATE            NOT NULL
);

CREATE TABLE IF NOT EXISTS pet_shop.funcionario
(
    id              INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome            VARCHAR(255)    NOT NULL,
    cpf             VARCHAR(14)     NOT NULL,
    data_nascimento DATE            NOT NULL,
    cargo           VARCHAR(100)    NOT NULL
);

CREATE TABLE IF NOT EXISTS pet_shop.consulta
(
    id         INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome       VARCHAR(255)    NOT NULL,
    observacao VARCHAR(500)    NOT NULL,
    horario    DATETIME        NOT NULL,
    valor      DOUBLE          NOT NULL,
    animal_id  INT             NOT NULl,
    cliente_id INT             NOT NULl
);

ALTER TABLE pet_shop.animal
    ADD CONSTRAINT fk_animal_especie
        FOREIGN KEY (especie_id)
            REFERENCES pet_shop.especie (id)
;

ALTER TABLE pet_shop.consulta
    ADD CONSTRAINT fk_consulta_cliente
        FOREIGN KEY (cliente_id)
            REFERENCES pet_shop.cliente (id)
;