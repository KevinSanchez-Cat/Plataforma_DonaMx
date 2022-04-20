package validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Validaciones {

    public static boolean isEmail(String correo) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        return mather.find();
    }
}
