package br.com.pet_shop.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Consulta {
	
	private Integer id;
	
	private String nome;
	
	private String observacao;
	
	private LocalDateTime horario;
	
	private Cliente cliente;
	
	private List<Animal> animais = new ArrayList<>();
	
	private Double valor;

	public Consulta() {
	}
	
	public Consulta(Integer id) {
		this.id = id;
	}
	
	public Consulta(Integer id, String nome, String observacao, LocalDateTime horario, Cliente cliente,
			List<Animal> animais, Double valor) {
		this.id = id;
		this.nome = nome;
		this.observacao = observacao;
		this.horario = horario;
		this.cliente = cliente;
		this.animais = animais;
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

	public LocalDateTime getHorario() {
		return horario;
	}

	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
