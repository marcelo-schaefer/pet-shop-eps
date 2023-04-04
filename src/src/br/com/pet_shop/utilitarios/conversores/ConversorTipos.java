package br.com.pet_shop.utilitarios.conversores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lucas
 */
public final class ConversorTipos {

    private ConversorTipos() {
    }

    public static Date stringParaDate(String data) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            return simpleDateFormat.parse(data);
        } catch (ParseException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static String dateParaString(Date data) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(data);
    }

    public static java.sql.Date dateParaDateSql(Date date) {
        return new java.sql.Date(date.getTime());
    }
}
