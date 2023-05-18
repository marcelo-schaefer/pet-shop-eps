package br.com.pet_shop.entidades;

import java.util.Date;

public class Consulta {

    private Integer id;

    private String nome;

    private String observacao;

    private Date horario;

    private Double valor;

    private Animal animal;

    public Consulta() {
    }

    public Consulta(Integer id) {
        this.id = id;
    }

    public Consulta(String nome, String observacao, Date horario, Double valor, Animal animal) {
        this.nome = nome;
        this.observacao = observacao;
        this.horario = horario;
        this.valor = valor;
        this.animal = animal;
    }

    public Consulta(Integer id, String nome, String observacao, Date horario, Double valor, Animal animal) {
        this.id = id;
        this.nome = nome;
        this.observacao = observacao;
        this.horario = horario;
        this.valor = valor;
        this.animal = animal;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
