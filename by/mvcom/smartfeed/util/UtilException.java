package by.mvcom.smartfeed.util;

/**
 * Created by puma on 22.06.16.
 */
public class UtilException extends Exception {

    public UtilException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UtilException(Throwable cause) {
        super(cause);
    }

    public UtilException(String message, Throwable cause) {
        super(message, cause);
    }

    public UtilException(String message) {
        super(message);
    }

    public UtilException() {
    }
}
