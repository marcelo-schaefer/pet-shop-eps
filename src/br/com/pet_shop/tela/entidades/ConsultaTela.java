package br.com.pet_shop.tela.entidades;

import br.com.pet_shop.entidades.Animal;
import br.com.pet_shop.entidades.Consulta;
import br.com.pet_shop.tela.dados.LerTela;

public final class ConsultaTela {

    private static final String CADASTRAR_CONSULTA_TITULO = "Cadastrar Consulta";

    private static final String ATUALIZAR_CONSULTA_TITULO = "Atualizar Consulta";

    private static final String BUSCAR_CONSULTA_TITULO = "Buscar Consulta";

    private static final String DELETAR_CONSULTA_TITULO = "Deletar Consulta";

    private ConsultaTela() {
    }

    public static Consulta criar() {
        var nome = LerTela.lerString(CADASTRAR_CONSULTA_TITULO, "Nome:");
        var observacao = LerTela.lerString(CADASTRAR_CONSULTA_TITULO, "Observação:");
        var horario = LerTela.lerLocalTime(CADASTRAR_CONSULTA_TITULO, "Horário:");
        var animalId = LerTela.lerInteger(CADASTRAR_CONSULTA_TITULO, "Identificador do Animal:");
        var valor = LerTela.lerDouble(CADASTRAR_CONSULTA_TITULO, "Valor:");

        return new Consulta(
            nome,
            observacao,
            horario,
            valor,
            new Animal(animalId)
        );
    }

    public static Consulta atualizar() {
        var id = LerTela.lerInteger(ATUALIZAR_CONSULTA_TITULO, "Id:");
        var nome = LerTela.lerString(ATUALIZAR_CONSULTA_TITULO, "Nome:");
        var observacao = LerTela.lerString(ATUALIZAR_CONSULTA_TITULO, "Observação:");
        var horario = LerTela.lerLocalTime(ATUALIZAR_CONSULTA_TITULO, "Horário:");
        var animalId = LerTela.lerInteger(ATUALIZAR_CONSULTA_TITULO, "Identificador do Animal:");
        var valor = LerTela.lerDouble(ATUALIZAR_CONSULTA_TITULO, "Valor:");

        return new Consulta(
            id,
            nome,
            observacao,
            horario,
            valor,
            new Animal(animalId)
        );
    }

    public static Consulta buscar() {
        var id = LerTela.lerInteger(BUSCAR_CONSULTA_TITULO, "Id:");

        return new Consulta(id);
    }

    public static Consulta deletar() {
        var id = LerTela.lerInteger(DELETAR_CONSULTA_TITULO, "Id:");

        return new Consulta(id);
    }
}
