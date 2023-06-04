package br.com.pet_shop.entidades;

import java.time.LocalTime;

public class Consulta {

    private Integer id;

    private String nome;

    private String observacao;

    private LocalTime horario;

    private Double valor;

    private Animal animal;

    private Funcionario funcionario;

    public Consulta() {
    }

    public Consulta(Integer id) {
        this.id = id;
    }

    public Consulta(String nome, String observacao, LocalTime horario, Double valor, Animal animal, Funcionario funcionario) {
        this.nome = nome;
        this.observacao = observacao;
        this.horario = horario;
        this.valor = valor;
        this.animal = animal;
        this.funcionario = funcionario;
    }

    public Consulta(Integer id, String nome, String observacao, LocalTime horario, Double valor, Animal animal, Funcionario funcionario) {
        this.id = id;
        this.nome = nome;
        this.observacao = observacao;
        this.horario = horario;
        this.valor = valor;
        this.animal = animal;
        this.funcionario = funcionario;
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

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
