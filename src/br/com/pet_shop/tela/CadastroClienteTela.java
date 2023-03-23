package br.com.pet_shop.tela;

import java.util.Date;

import br.com.pet_shop.entidades.Cliente;

public final class CadastroClienteTela {

	private static final String CADASTRAR_CLIENTE_TITULO = "Cadastrar Cliente";
	
	private CadastroClienteTela() {
	}

	public static Cliente criar() {
		var cliente = new Cliente();
		
		cliente.setNome(lerString("Nome:"));
		cliente.setCpf(lerString("CPF:"));
		cliente.setDataNascimento(lerDate("Data de Nascimento:"));
		
		return cliente;
	}
	
	private static String lerString(String message) {
		return LerTela.lerString(message, CADASTRAR_CLIENTE_TITULO);
	}
	
	private static Date lerDate(String message) {
		return null;
	}
}
