package br.com.pet_shop.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Medico extends Pessoa {

    private List<Consulta> consultas = new ArrayList<>();

    public Medico(Integer id) {
        super(id);
    }

    public Medico(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public Medico(Integer id, List<Consulta> consultas) {
        super(id);
        this.consultas = consultas;
    }

    public Medico(String nome, String cpf, Date dataNascimento) {
        super(nome, cpf, dataNascimento);
    }

    public Medico(String nome, String cpf, Date dataNascimento, List<Consulta> consultas) {
        super(nome, cpf, dataNascimento);
        this.consultas = consultas;
    }

    public Medico(Integer id, String nome, String cpf, Date dataNascimento) {
        super(id, nome, cpf, dataNascimento);
    }

    public Medico(Integer id, String nome, String cpf, Date dataNascimento, List<Consulta> consultas) {
        super(id, nome, cpf, dataNascimento);
        this.consultas = consultas;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
