package menu.util;

public class Validator {
    private final static String EMPTY_INPUT = "빈 문자입니다.";
    private final static String IS_NUMERIC = "숫자여야 합니다.";

    public static void isEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT);
        }
    }

    public static void isDigit(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NUMERIC);
        }
    }
}
