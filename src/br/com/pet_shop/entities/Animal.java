package br.com.pet_shop.entities;

import java.time.LocalDate;

import br.com.pet_shop.enums.SexoEnum;

public class Animal {
	
	private Integer id;
	
	private String nome;
	
	private LocalDate dataNascimento;
	
	private SexoEnum sexo;

	public Animal() {
	}
	
	public Animal(Integer id) {
		this.id = id;
	}
	
	public Animal(Integer id, String nome, LocalDate dataNascimento, SexoEnum sexo) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}
}
