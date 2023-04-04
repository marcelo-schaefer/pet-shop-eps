package br.com.pet_shop.tela.dados;

import br.com.pet_shop.enums.CargoEnum;
import br.com.pet_shop.enums.EspecieEnum;
import br.com.pet_shop.enums.SexoEnum;

public final class LerEnumTela {

    private LerEnumTela() {
    }

    public static CargoEnum lerCargoEnum(String titulo) {
        var mensagem = "Selecione uma das opções:"
            .concat("\n")
            .concat("1 - Médico")
            .concat("\n")
            .concat("2 - Atendente");

        var opcao = lerOpcao(
            CargoEnum.values().length,
            titulo,
            mensagem
        );

        return CargoEnum.pegarPorOpcao(opcao);
    }

    public static SexoEnum lerSexoEnum(String titulo) {
        var mensagem = "Selecione uma das opções:"
            .concat("\n")
            .concat("1 - Feminino")
            .concat("\n")
            .concat("2 - Masculino")
            .concat("\n")
            .concat("3 - Hemafrodita");

        var opcao = lerOpcao(
            SexoEnum.values().length,
            titulo,
            mensagem
        );

        return SexoEnum.pegarPorOpcao(opcao);
    }

    public static EspecieEnum lerEspecieEnum(String titulo) {
        var mensagem = "Selecione uma das opções:"
            .concat("\n")
            .concat("1 - Feminino")
            .concat("\n")
            .concat("2 - Masculino")
            .concat("\n")
            .concat("3 - Hemafrodita");

        var opcao = lerOpcao(
            EspecieEnum.values().length,
            titulo,
            mensagem
        );

        return EspecieEnum.pegarPorOpcao(opcao);
    }

    private static Integer lerOpcao(Integer ate, String titulo, String mensagem) {
        do {
            var opcao = LerTela.lerInteger(titulo, mensagem);

            if (opcao >= 1 && opcao <= ate) {
                return opcao;
            }
        } while (true);
    }
}
