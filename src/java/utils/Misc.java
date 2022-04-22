package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Misc {

    public static java.util.Date getDateTimeActualJava() {
        java.util.Date date = null;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String timeStamp = formato.format(Calendar.getInstance().getTime());

            date = formato.parse(timeStamp);
        } catch (ParseException ex) {
            Logg.error("No se pudo obtener la fecha, Parseo incorrecto " + ex.getMessage());
        }
        return date;
    }

    public static java.sql.Date getDateTimeActualSQL() {
        long miliseconds = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(miliseconds);
        return date;
    }

    public static java.sql.Date transformDateTimeJavaSql(java.util.Date jDate) {
        long timeInMilliSeconds = jDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(timeInMilliSeconds);
        return sqlDate;
    }

    public static java.util.Date transformDateTimeSqlJava(java.sql.Date sqlDate) {
        long timeInMilliSeconds = sqlDate.getTime();
        java.sql.Date jDate = new java.sql.Date(timeInMilliSeconds);
        return jDate;
    }

    public static String getFormatDate(Object date) {
        String dateFormat = "";
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        if (date instanceof java.sql.Date) {
            dateFormat = formato.format((java.sql.Date) date);
        } else if (date instanceof java.util.Date) {
            dateFormat = formato.format((java.util.Date) date);
        }
        return dateFormat;
    }
}
