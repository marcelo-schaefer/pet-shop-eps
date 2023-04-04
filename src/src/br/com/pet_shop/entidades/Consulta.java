package br.com.pet_shop.entidades;

import java.util.Date;

public class Consulta {

    private Integer id;

    private String nome;

    private String observacao;

    private Date horario;

    private Cliente cliente;

    private Animal animal;

    private Double valor;

    public Consulta() {
    }

    public Consulta(Integer id) {
        this.id = id;
    }

    public Consulta(String nome, String observacao, Date horario, Cliente cliente, Animal animal, Double valor) {
        this.nome = nome;
        this.observacao = observacao;
        this.horario = horario;
        this.cliente = cliente;
        this.animal = animal;
        this.valor = valor;
    }

    public Consulta(Integer id, String nome, String observacao, Date horario, Cliente cliente, Animal animal,
                    Double valor) {
        this.id = id;
        this.nome = nome;
        this.observacao = observacao;
        this.horario = horario;
        this.cliente = cliente;
        this.animal = animal;
        this.valor = valor;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Animal getAnimais() {
        return animal;
    }

    public void setAnimais(Animal animal) {
        this.animal = animal;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
