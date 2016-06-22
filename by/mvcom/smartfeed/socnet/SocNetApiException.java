package by.mvcom.smartfeed.socnet;

/**
 * Created by puma on 22.06.16.
 */
public class SocNetApiException extends Exception {

    public SocNetApiException() {
    }

    public SocNetApiException(String message) {
        super(message);
    }

    public SocNetApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public SocNetApiException(Throwable cause) {
        super(cause);
    }

    public SocNetApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
