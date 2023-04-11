package br.com.pet_shop.tela.entidades;

import br.com.pet_shop.entidades.Funcionario;
import br.com.pet_shop.tela.dados.LerTela;

public final class FuncionarioTela {

    private static final String CADASTRAR_FUNCIONARIO_TITULO = "Cadastrar Funcionário";

    private static final String ATUALIZAR_FUNCIONARIO_TITULO = "Atualizar Funcionário";

    private static final String BUSCAR_FUNCIONARIO_TITULO = "Buscar Funcionário";

    private static final String DELETAR_FUNCIONARIO_TITULO = "Deletar Funcionário";

    private FuncionarioTela() {
    }

    public static Funcionario criar() {
        var nome = LerTela.lerString(CADASTRAR_FUNCIONARIO_TITULO, "Nome:");
        var cpf = LerTela.lerString(CADASTRAR_FUNCIONARIO_TITULO, "Cpf:");
        var dataNascimento = LerTela.lerDate(CADASTRAR_FUNCIONARIO_TITULO, "Data de Nascimento:");
        var cargo = LerTela.lerString(CADASTRAR_FUNCIONARIO_TITULO, "Cargo:");
        
        return new Funcionario(
            nome,
            cpf,
            dataNascimento,
            cargo
        );
    }

    public static Funcionario atualizar() {
        var id = LerTela.lerInteger(ATUALIZAR_FUNCIONARIO_TITULO, "Id:");
        var nome = LerTela.lerString(ATUALIZAR_FUNCIONARIO_TITULO, "Nome:");
        var cpf = LerTela.lerString(CADASTRAR_FUNCIONARIO_TITULO, "Cpf:");
        var dataNascimento = LerTela.lerDate(ATUALIZAR_FUNCIONARIO_TITULO, "Data de Nascimento:");
        var cargo = LerTela.lerString(CADASTRAR_FUNCIONARIO_TITULO, "Cargo:");


        return new Funcionario(
            id,
            nome,
            cpf,
            dataNascimento,
            cargo
        );
    }

    public static Funcionario buscar() {
        var id = LerTela.lerInteger(BUSCAR_FUNCIONARIO_TITULO, "Id:");

        return new Funcionario(id);
    }

    public static Funcionario deletar() {
        var id = LerTela.lerInteger(DELETAR_FUNCIONARIO_TITULO, "Id:");

        return new Funcionario(id);
    }
}
