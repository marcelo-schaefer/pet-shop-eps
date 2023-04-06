package br.com.pet_shop.entidades;


import br.com.pet_shop.enums.SexoEnum;

import java.util.Date;

public class Animal {
	
	private Integer id;
	
	private String nome;

	private String detalhe;

	private Date dataNascimento;
	
	private SexoEnum sexo;
	
	private Boolean ativo;

	private Especie especie;

	public Animal() {
	}
	
	public Animal(Integer id) {
		this.id = id;
	}

	public Animal(String nome, String detalhe, Date dataNascimento, SexoEnum sexo, Boolean ativo, Especie especie) {
		this.nome = nome;
		this.detalhe = detalhe;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.ativo = ativo;
		this.especie = especie;
	}

	public Animal(Integer id, String nome, String detalhe, Date dataNascimento, SexoEnum sexo, Boolean ativo, Especie especie) {
		this.id = id;
		this.nome = nome;
		this.detalhe = detalhe;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.ativo = ativo;
		this.especie = especie;
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

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}
}
