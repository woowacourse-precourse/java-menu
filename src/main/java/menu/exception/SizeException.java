package menu.exception;

public class SizeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] %s 사이즈는 %d이상, %d이하여야 합니다.";

    public SizeException(String name, int minSize, int maxSize) {
        super(String.format(ERROR_MESSAGE, name, minSize, maxSize));
    }
}
