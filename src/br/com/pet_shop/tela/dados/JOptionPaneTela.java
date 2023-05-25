package br.com.pet_shop.tela.dados;

import javax.swing.*;

public final class JOptionPaneTela {

    private JOptionPaneTela() {
    }

    public static Object optionInputPergunta(String titulo, String menssagem) {
        return JOptionPane.showInputDialog(
            null,
            menssagem,
            titulo,
            JOptionPane.QUESTION_MESSAGE
        );
    }

    public static Integer optionConfirmPergunta(String titulo, String menssagem) {
        return JOptionPane.showConfirmDialog(
            null,
            menssagem,
            titulo,
            JOptionPane.QUESTION_MESSAGE
        );
    }

    public static void optionMensagemAlerta(String titulo, String menssagem) {
        JOptionPane.showMessageDialog(
            null,
            menssagem,
            titulo,
            JOptionPane.WARNING_MESSAGE
        );
    }

    public static void optionMensagemInfo(String titulo, String menssagem) {
        JOptionPane.showMessageDialog(
            null,
            menssagem,
            titulo,
            JOptionPane.NO_OPTION
        );
    }
}
