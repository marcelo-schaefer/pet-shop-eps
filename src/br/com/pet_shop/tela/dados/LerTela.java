package br.com.pet_shop.tela.dados;

import java.text.SimpleDateFormat;
import java.util.Date;

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
            }
        } while (true);
    }


    public static Integer lerInteger(String titulo, String mensagem) {
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
                    "Valor informado é inválido, informe um valor numérico inteiro."
                );
            }
        } while (true);
    }

    public static Boolean lerBoolean(String titulo, String mensagem) {
        return JOptionPaneTela.optionConfirmPergunta(titulo, mensagem) == 0;
    }

    public static Date lerDate(String titulo, String mensagem) {
        var simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        mensagem = "Informe a data no seguinte formato dd/MM/aaaa"
            .concat("\n")
            .concat(mensagem)
        ;

        do {
            try {
                var dateString = lerString(titulo, mensagem);

                return simpleDateFormat.parse(dateString);
            } catch (Exception exception) {
            }
        }
        while (true);
    }
}
