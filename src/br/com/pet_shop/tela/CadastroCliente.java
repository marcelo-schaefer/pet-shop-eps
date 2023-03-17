package br.com.pet_shop.tela;

import br.com.pet_shop.entidades.Cliente;

public final class CadastroCliente {

	private CadastroCliente() {
	}

	public static Cliente salvar() {
		var cliente = new Cliente();

		ExibirTela.limparTela();
		ExibirTela.linha();

		ExibirTela.println("Cadastro do cliente");
		cliente = pedirDados();

		ExibirTela.linha();
		return cliente;
	}

	private static Cliente pedirDados() {
		var cliente = new Cliente();

		ExibirTela.print("Nome: ");
		cliente.setNome(LerTela.lerString());

		ExibirTela.print("CPF: ");
		cliente.setCpf(LerTela.lerString());

		var dataInvalida = false;
		do {
			try {
				ExibirTela.print("Data Nascimento: ");
				cliente.setDataNascimento(LerTela.lerData());
			} catch (Exception e) {
				dataInvalida = true;
			}
		} while (dataInvalida);

		return cliente;
	}
}
