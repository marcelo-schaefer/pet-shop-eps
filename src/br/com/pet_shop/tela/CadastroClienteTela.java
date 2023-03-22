package br.com.pet_shop.tela;

import br.com.pet_shop.entidades.Cliente;

public final class CadastroClienteTela {

	private CadastroClienteTela() {
	}

	public static Cliente criar() {
		var cliente = new Cliente();

		ExibirTela.println("Cadastro do cliente");
		cliente = pedirDados();

		return cliente;
	}

	private static Cliente pedirDados() {
		var cliente = new Cliente();

		ExibirTela.print("Nome: ");
		cliente.setNome(
			LerTela.lerString(
				"Cadatro",
				"Nome:"
			)
		);

		ExibirTela.print("CPF: ");
		cliente.setCpf(
			LerTela.lerString(
				"Cadatro",
				"CPF:"
			)
		);

		return cliente;
	}
}
