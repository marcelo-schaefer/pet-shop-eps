package br.com.pet_shop.utilitarios.conversores;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @author lucas
 */
public final class ConversorTipos {

    private static final ZoneId FUSO_HORARIO_SAO_PAULO = ZoneId.of("America/Sao_Paulo");

    private static final ZoneOffset FUSO_HORARIO_SAO_PAULO_ZONE_OFFSET = FUSO_HORARIO_SAO_PAULO.getRules().getOffset(
        LocalDateTime.now()
    );

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

    public static LocalTime dateParaLocalTime(Date date) {
        return date
            .toInstant()
            .atZone(FUSO_HORARIO_SAO_PAULO)
            .toLocalTime();
    }
}
