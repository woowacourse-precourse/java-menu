package menu.validator;

public class InputValidator {

    public static void isCorrectLength(final String input) {

        if (input.length() < 2 || input.length() > 4) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 최소 2글자 이상, 4글자 이하 입력해야 합니다.");
        }
    }
}
