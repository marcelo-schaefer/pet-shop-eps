package br.com.pet_shop.tela.entidades;

import br.com.pet_shop.entidades.Cliente;
import br.com.pet_shop.tela.dados.LerTela;

public final class ClienteTela {

    private static final String CADASTRAR_CLIENTE_TITULO = "Cadastrar Cliente";

    private static final String ATUALIZAR_CLIENTE_TITULO = "Atualizar Cliente";

    private static final String BUSCAR_CLIENTE_TITULO = "Buscar Cliente";

    private static final String DELETAR_CLIENTE_TITULO = "Deletar Cliente";

    private ClienteTela() {
    }

    public static Cliente criar() {
        var nome = LerTela.lerString(CADASTRAR_CLIENTE_TITULO, "Nome:");
        var cpf = LerTela.lerString(CADASTRAR_CLIENTE_TITULO, "CPF:");
        var dataNascimento = LerTela.lerDate(CADASTRAR_CLIENTE_TITULO, "Data de Nascimento:");

        return new Cliente(
            nome,
            cpf,
            dataNascimento
        );
    }

    public static Cliente atualizar() {
        var id = LerTela.lerInteger(ATUALIZAR_CLIENTE_TITULO, "Id:");
        var nome = LerTela.lerString(ATUALIZAR_CLIENTE_TITULO, "Nome:");
        var cpf = LerTela.lerString(ATUALIZAR_CLIENTE_TITULO, "CPF:");
        var dataNascimento = LerTela.lerDate(ATUALIZAR_CLIENTE_TITULO, "Data de Nascimento:");

        return new Cliente(
            id,
            nome,
            cpf,
            dataNascimento
        );
    }

    public static Cliente buscar() {
        var id = LerTela.lerInteger(BUSCAR_CLIENTE_TITULO, "Id:");

        return new Cliente(id);
    }

    public static Cliente deletar() {
        var id = LerTela.lerInteger(DELETAR_CLIENTE_TITULO, "Id:");

        return new Cliente(id);
    }
}
