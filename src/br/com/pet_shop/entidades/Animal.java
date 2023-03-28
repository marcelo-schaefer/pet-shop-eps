package br.com.pet_shop.entidades;

import java.sql.Date;

import br.com.pet_shop.enums.SexoEnum;

public class Animal {
	
	private Integer id;
	
	private String nome;
	
	private Date dataNascimento;
	
	private SexoEnum sexo;
	
	private Boolean ativo;

	public Animal() {
	}
	
	public Animal(Integer id) {
		this.id = id;
	}
	
	public Animal(Integer id, String nome, Date dataNascimento, SexoEnum sexo, Boolean ativo) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.ativo = ativo;
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

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
