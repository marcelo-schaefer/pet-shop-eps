package br.com.pet_shop.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funcionario extends Pessoa {

    private String cargo;

    public Funcionario(Integer id) {
        super(id);
    }

    public Funcionario(String cargo) {
        this.cargo = cargo;
    }

    public Funcionario(Integer id, String cargo) {
        super(id);
        this.cargo = cargo;
    }

    public Funcionario(String nome, String cpf, Date dataNascimento) {
        super(nome, cpf, dataNascimento);
    }

    public Funcionario(String nome, String cpf, Date dataNascimento, String cargo) {
        super(nome, cpf, dataNascimento);
        this.cargo = cargo;
    }

    public Funcionario(Integer id, String nome, String cpf, Date dataNascimento) {
        super(id, nome, cpf, dataNascimento);
    }

    public Funcionario(Integer id, String nome, String cpf, Date dataNascimento, String cargo) {
        super(id, nome, cpf, dataNascimento);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
