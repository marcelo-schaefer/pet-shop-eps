package br.com.pet_shop.tela;

public final class LerTela {

    private LerTela() {
    }

    public static String lerString(String titulo, String mensagem) {
        return String.valueOf(
            JOptionPaneTela.optionInputPergunta(
                titulo,
                mensagem
            )
        );
    }

    public static Double lerDouble(String titulo, String mensagem) {
        boolean invalido = false;

        do {
            try {
                return Double.valueOf(
                    lerString(
                        titulo,
                        mensagem
                    )
                );
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


    public static Integer lerInteger(String titulo, String mensagem) {
        boolean invalido = false;

        do {
            try {
                return Integer.valueOf(
                    lerString(
                        titulo,
                        mensagem
                    )
                );
            } catch (Exception exception) {
                JOptionPaneTela.optionMensagemAlerta(
                    "Inválido",
                    "Valor informado é inválido, informe um valor numérico sem casas decimais."
                );
                invalido = true;
            }
        } while (invalido);

        return null;
    }

    public static Boolean lerBoolean(String titulo, String mensagem) {
        return JOptionPaneTela.optionConfirmPergunta(titulo, mensagem) == 0;
    }
}
