package br.com.pet_shop.entidades;

import java.util.Date;

import br.com.pet_shop.enums.CargoEnum;

public class Funcionario extends Pessoa {
	
	private CargoEnum cargo;

	public Funcionario() {
		super();
	}
	
	public Funcionario(Integer id) {
		super(id);
	}

	public Funcionario(Integer id, String nome, String cpf,
			Date dataNascimento, CargoEnum cargo) {
		super(id, nome, cpf, dataNascimento);
		this.cargo = cargo;
	}

	public CargoEnum getCargo() {
		return cargo;
	}

	public void setCargo(CargoEnum cargo) {
		this.cargo = cargo;
	}	
}
