package br.com.pet_shop.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente extends Pessoa {
	
	private List<Animal> animais = new ArrayList<>();
	
	private List<Consulta> historicoConsultas = new ArrayList<>();

	public Cliente() {
		super();
	}

	public Cliente(Integer id) {
		super(id);
	}
	
	public Cliente(Integer id, String nome, String cpf, Date dataNascimento,
			List<Animal> animais, List<Consulta> historicoConsultas) {
		super(id, nome, cpf, dataNascimento);
		this.animais = animais;
		this.historicoConsultas = historicoConsultas;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}

	public List<Consulta> getHistoricoConsultas() {
		return historicoConsultas;
	}

	public void setHistoricoConsultas(List<Consulta> historicoConsultas) {
		this.historicoConsultas = historicoConsultas;
	}
}
