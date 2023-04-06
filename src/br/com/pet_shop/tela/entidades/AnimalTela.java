package br.com.pet_shop.tela.entidades;

import br.com.pet_shop.entidades.Animal;
import br.com.pet_shop.entidades.Especie;
import br.com.pet_shop.tela.dados.LerEnumTela;
import br.com.pet_shop.tela.dados.LerTela;

public final class AnimalTela {

    private static final String CADASTRAR_ANIMAL_TITULO = "Cadastrar Animal";

    private static final String ATUALIZAR_ANIMAL_TITULO = "Atualizar Animal";

    private static final String BUSCAR_ANIMAL_TITULO = "Buscar Animal";

    private static final String DELETAR_ANIMAL_TITULO = "Deletar Animal";

    private AnimalTela() {
    }

    public static Animal criar() {
        var nome = LerTela.lerString(CADASTRAR_ANIMAL_TITULO, "Nome:");
        var detalhe = LerTela.lerString(CADASTRAR_ANIMAL_TITULO, "Detalhe:");
        var dataNascimento = LerTela.lerDate(CADASTRAR_ANIMAL_TITULO, "Data de Nascimento:");
        var sexoEnum = LerEnumTela.lerSexoEnum(CADASTRAR_ANIMAL_TITULO);
        var especieId = LerTela.lerInteger(CADASTRAR_ANIMAL_TITULO, "Identificador da especie:");

        return new Animal(
            nome,
            detalhe,
            dataNascimento,
            sexoEnum,
            Boolean.TRUE,
            new Especie(especieId)
        );
    }

    public static Animal atualizar() {
        var id = LerTela.lerInteger(ATUALIZAR_ANIMAL_TITULO, "Id:");
        var nome = LerTela.lerString(ATUALIZAR_ANIMAL_TITULO, "Nome:");
        var detalhe = LerTela.lerString(ATUALIZAR_ANIMAL_TITULO, "Detalhe:");
        var dataNascimento = LerTela.lerDate(ATUALIZAR_ANIMAL_TITULO, "Data de Nascimento:");
        var sexoEnum = LerEnumTela.lerSexoEnum(ATUALIZAR_ANIMAL_TITULO);
        var especieId = LerTela.lerInteger(ATUALIZAR_ANIMAL_TITULO, "Identificador da especie:");

        return new Animal(
            id,
            nome,
            detalhe,
            dataNascimento,
            sexoEnum,
            Boolean.TRUE,
            new Especie(especieId)
        );
    }

    public static Animal buscar() {
        var id = LerTela.lerInteger(BUSCAR_ANIMAL_TITULO, "Id:");

        return new Animal(id);
    }

    public static Animal deletar() {
        var id = LerTela.lerInteger(DELETAR_ANIMAL_TITULO, "Id:");

        return new Animal(id);
    }
}
