package br.com.pet_shop.entidades;


import br.com.pet_shop.enums.SexoEnum;

import java.util.Date;

public class Animal {

    private Integer id;

    private String nome;

    private String detalhe;

    private Date dataNascimento;

    private SexoEnum sexo;

    private Especie especie;

    private Cliente cliente;

    public Animal() {
    }

    public Animal(Integer id) {
        this.id = id;
    }

    public Animal(String nome, String detalhe, Date dataNascimento, SexoEnum sexo, Especie especie,
                  Cliente cliente) {
        this.nome = nome;
        this.detalhe = detalhe;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.especie = especie;
        this.cliente = cliente;
    }

    public Animal(Integer id, String nome, String detalhe, Date dataNascimento, SexoEnum sexo, Especie especie,
                  Cliente cliente) {
        this.id = id;
        this.nome = nome;
        this.detalhe = detalhe;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.especie = especie;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }


    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
