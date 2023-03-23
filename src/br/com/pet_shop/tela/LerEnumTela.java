package br.com.pet_shop.tela;

import br.com.pet_shop.enums.CargoEnum;
import br.com.pet_shop.enums.EspecieEnum;
import br.com.pet_shop.enums.SexoEnum;

public final class LerEnumTela {
    private LerEnumTela() {
    }

    public static CargoEnum lerCargoEnum(String titulo) {
        boolean invalido = false;

        var menssagem = "Selecione uma das opções: \n"
                + "1 - Médico"
                + "2 - Atendente";

        do {
            try {
                var opcao = lerOpcao(
                        1,
                        CargoEnum.values().length,
                        titulo,
                        menssagem
                );

                return CargoEnum.pegarPorOpcao(opcao);
            } catch (Exception exception) {
                JOptionPaneTela.optionMensagemAlerta(
                        "Inválido",
                        "Valor informado é inválido, informe um valor numérico."
                );
                invalido = true;
            }
        } while (invalido);

        return null;
    }

    public static SexoEnum lerSexoEnum(String titulo) {
        boolean invalido = false;

        var menssagem = "Selecione uma das opções:"
                .concat("\n")
                .concat("1 - Feminino")
                .concat("\n")
                .concat("2 - Masculino")
                .concat("\n")
                .concat("3 - Hemafrodita");

        do {
            try {
                var opcao = lerOpcao(
                        1,
                        SexoEnum.values().length,
                        titulo,
                        menssagem
                );

                return SexoEnum.pegarPorOpcao(opcao);
            } catch (Exception exception) {
                JOptionPaneTela.optionMensagemAlerta(
                        "Inválido",
                        "Valor informado é inválido, informe um valor numérico."
                );
                invalido = true;
            }
        } while (invalido);

        return null;
    }

    public static EspecieEnum lerEspecieEnum(String titulo) {
        boolean invalido = false;

        var menssagem = "Selecione uma das opções:"
                .concat("\n")
                .concat("1 - Feminino")
                .concat("\n")
                .concat("2 - Masculino")
                .concat("\n")
                .concat("3 - Hemafrodita");

        do {
            try {
                var opcao = lerOpcao(
                        1,
                        EspecieEnum.values().length,
                        titulo,
                        menssagem
                );

                return EspecieEnum.pegarPorOpcao(opcao);
            } catch (Exception exception) {
                JOptionPaneTela.optionMensagemAlerta(
                        "Inválido",
                        "Valor informado é inválido, informe um valor numérico."
                );
                invalido = true;
            }
        } while (invalido);

        return null;
    }

    private static Integer lerOpcao(Integer de, Integer ate, String titulo, String menssagem) {
        boolean invalido = false;

        do {
            try {
                var opcao = LerTela.lerInteger(titulo, menssagem);

                if (opcao >= de && opcao <= ate) {
                    return opcao;
                }

                throw new RuntimeException("");
            } catch (Exception exception) {
                JOptionPaneTela.optionMensagemAlerta(
                        "Inválido",
                        "Opção inválida, informe uma opção entre "
                        .concat(de.toString())
                        .concat(" e ")
                        .concat(ate.toString())
                );
                invalido = true;
            }
        } while (invalido);

        return null;
    }
}
