package menu.util;

public class NullValidator {

    private static final String NULL_MESSAGE = "NULL 이 포함되면 안 됩니다";

    private NullValidator() {
    }

    public static void throwIfNull(Object any) {
        if (any == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }
}
