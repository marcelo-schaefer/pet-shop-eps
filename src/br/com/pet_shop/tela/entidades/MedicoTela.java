package br.com.pet_shop.tela.entidades;

import br.com.pet_shop.entidades.Medico;
import br.com.pet_shop.entidades.Especie;
import br.com.pet_shop.tela.dados.LerEnumTela;
import br.com.pet_shop.tela.dados.LerTela;

public final class MedicoTela {

    private static final String CADASTRAR_MEDICO_TITULO = "Cadastrar Medico";

    private static final String ATUALIZAR_MEDICO_TITULO = "Atualizar Medico";

    private static final String BUSCAR_MEDICO_TITULO = "Buscar Medico";

    private static final String DELETAR_MEDICO_TITULO = "Deletar Medico";

    private MedicoTela() {
    }

    public static Medico criar() {
        var nome = LerTela.lerString(CADASTRAR_MEDICO_TITULO, "Nome:");
        var cpf = LerTela.lerString(CADASTRAR_MEDICO_TITULO, "Cpf:");
        var dataNascimento = LerTela.lerDate(CADASTRAR_MEDICO_TITULO, "Data de Nascimento:");

        return new Medico(
            nome,
            cpf,
            dataNascimento
        );
    }

    public static Medico atualizar() {
        var id = LerTela.lerInteger(ATUALIZAR_MEDICO_TITULO, "Id:");
        var nome = LerTela.lerString(ATUALIZAR_MEDICO_TITULO, "Nome:");
        var cpf = LerTela.lerString(CADASTRAR_MEDICO_TITULO, "Cpf:");
        var dataNascimento = LerTela.lerDate(ATUALIZAR_MEDICO_TITULO, "Data de Nascimento:");

        return new Medico(
            id,
            nome,
            cpf,
            dataNascimento
        );
    }

    public static Medico buscar() {
        var id = LerTela.lerInteger(BUSCAR_MEDICO_TITULO, "Id:");

        return new Medico(id);
    }

    public static Medico deletar() {
        var id = LerTela.lerInteger(DELETAR_MEDICO_TITULO, "Id:");

        return new Medico(id);
    }
}
