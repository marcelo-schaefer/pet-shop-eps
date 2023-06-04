package br.com.pet_shop.utilitarios.conversores;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author lucas
 */
public final class ConversorTipos {

    private static final ZoneId FUSO_HORARIO_SAO_PAULO = ZoneId.of("America/Sao_Paulo");

    private ConversorTipos() {
    }

    public static java.sql.Date dateParaDateSql(Date date) {
        return new java.sql.Date(date.getTime());
    }

    public static LocalTime dateParaLocalTime(Date date) {
        return date
            .toInstant()
            .atZone(FUSO_HORARIO_SAO_PAULO)
            .toLocalTime();
    }
}
