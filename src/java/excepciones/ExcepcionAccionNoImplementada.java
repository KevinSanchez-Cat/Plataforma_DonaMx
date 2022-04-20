package excepciones;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ExcepcionAccionNoImplementada extends Exception {

    public ExcepcionAccionNoImplementada(String msj) {
        super(msj);
    }

    protected ExcepcionAccionNoImplementada(String message, Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
