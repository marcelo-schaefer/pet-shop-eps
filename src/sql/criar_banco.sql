create database if not exists pet_shop;
#
create table if not exists pet_shop.especie(
    id int primary key not null auto_increment,
    nome varchar(255) not null
);
#
create table if not exists pet_shop.animal (
    id int primary key not null auto_increment,
    nome varchar(255) not null,
    detalhe varchar(500),
    data_nascimento date not null,
    sexo varchar(12) not null,
    ativo tinyint not null, especie_id int not null,
    foreign key (especie_id)
        references especie(id)
);
#
create table if not exists pet_shop.cliente (
    id int primary key not null auto_increment,
    nome varchar(255) not null,
    cpf varchar(14) not null,
    data_nascimento date not null
);
#
create table if not exists pet_shop.funcionario (
    id int primary key not null auto_increment,
    nome varchar(255) not null,
    cpf varchar(14) not null,
    data_nascimento date not null,
    cargo varchar(100) not null
);
#
create table if not exists pet_shop.consulta (
    id int primary key not null auto_increment,
    nome varchar(255) not null,
    observacao varchar(500) not null,
    horario dateTIME not null,
    valor double not null,
    animal_id int not null,
    foreign key (animal_id)
        references animal(id)
);