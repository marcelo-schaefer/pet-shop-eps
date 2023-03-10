package br.com.pet_shop.entities;

import java.time.LocalDate;

public class Pessoa {
	
	private Integer id;
	
	private String nome;
	
	private String sobrenome;
	
	private String cpf;
	
	private LocalDate dataNascimento;
	
	public Pessoa() {
	}
	
	public Pessoa(Integer id) {
		this.id = id;
	}
	
	public Pessoa(Integer id, String nome, String sobrenome, String cpf, LocalDate dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
