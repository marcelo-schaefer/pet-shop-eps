package br.com.pet_shop.tela;

import br.com.pet_shop.entidades.Cliente;

import java.util.Date;

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

    public static Cliente atualizar() {
        var cliente = criar();

        cliente.setId(lerInteger("Id:"));

        return cliente;
    }



    private static String lerString(String message) {
        return LerTela.lerString(CADASTRAR_CLIENTE_TITULO, message);
    }

    private static Date lerDate(String message) {
        return null;
    }

    private static Integer lerInteger(String mensagem) {
        return LerTela.lerInteger(CADASTRAR_CLIENTE_TITULO, mensagem);
    }
}
