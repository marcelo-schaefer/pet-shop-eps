package br.com.pet_shop.tela.entidades;

import br.com.pet_shop.entidades.Especie;
import br.com.pet_shop.tela.dados.LerTela;

public final class EspecieTela {

    private static final String CADASTRAR_ESPECIE_TITULO = "Cadastrar Especie";

    private static final String ATUALIZAR_ESPECIE_TITULO = "Atualizar Especie";

    private static final String BUSCAR_ESPECIE_TITULO = "Buscar Especie";

    private static final String DELETAR_ESPECIE_TITULO = "Deletar Especie";

    private EspecieTela() {
    }

    public static Especie criar() {
        var nome = LerTela.lerString(CADASTRAR_ESPECIE_TITULO, "Nome:");

        return new Especie(nome);
    }

    public static Especie atualizar() {
        var id = LerTela.lerInteger(ATUALIZAR_ESPECIE_TITULO, "Id:");
        var nome = LerTela.lerString(ATUALIZAR_ESPECIE_TITULO, "Nome:");

        return new Especie(id, nome);
    }

    public static Especie buscar() {
        var id = LerTela.lerInteger(BUSCAR_ESPECIE_TITULO, "Id:");

        return new Especie(id);
    }

    public static Especie deletar() {
        var id = LerTela.lerInteger(DELETAR_ESPECIE_TITULO, "Id:");

        return new Especie(id);
    }
}
