package br.com.pet_shop.tela;

import javax.swing.*;

public final class LerTela {

    private LerTela() {
    }

    public static String lerString(String mensagem, String titulo) {
        return String.valueOf(
            optionInputPergunta(
                mensagem,
                titulo
            )
        );
    }

    public static Double lerDouble(String mensagem, String titulo) {
        boolean invalido = false;

        do {
            try {
                return Double.valueOf(
                    lerString(
                        mensagem,
                        titulo
                    )
                );
            } catch (Exception exception) {
                optionMensagemAlerta(
                    "Inválido",
                    "Valor informado é inválido, informe um valor numérico."
                );
                invalido = true;
            }
        } while (invalido);

        return null;
    }

    private static Object optionInputPergunta(String menssagem, String titulo) {
        return JOptionPane.showInputDialog(
            null,
            menssagem,
            titulo,
            JOptionPane.QUESTION_MESSAGE
        );
    }

    private static void optionMensagemAlerta(String menssagem, String titulo) {
        JOptionPane.showMessageDialog(
            null,
            menssagem,
            titulo,
            JOptionPane.WARNING_MESSAGE
        );
    }
}
