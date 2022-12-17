package menu.ui.input.exceptions;

public class Shared {
    private static final char COMMA = ',';
    private static final String COMMA_ERROR_MESSAGE = "[ERROR] 입력의 맨 첫번째 혹은 마지막 문자는 ',' 가 불가합니다";

    public void sharedExceptionChecking(String input) {
        boolean first = input.charAt(0) == COMMA;
        boolean last = input.charAt(input.length() - 1) == COMMA;
        if (first || last) {
            throw new IllegalArgumentException(COMMA_ERROR_MESSAGE);
        }
    }
}
