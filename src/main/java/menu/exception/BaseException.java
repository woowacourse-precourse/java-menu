package menu.exception;

public class BaseException extends IllegalArgumentException {

    public static final String ERROR_PREFIX = "[ERROR] ";

    public BaseException(String message) {
        super(ERROR_PREFIX + message);
    }
}
