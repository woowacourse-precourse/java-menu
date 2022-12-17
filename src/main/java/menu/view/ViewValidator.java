package menu.view;

import menu.view.constant.ValidationRegex;
import menu.view.constant.ViewErrorMessage;

import java.util.regex.Pattern;

public class ViewValidator {
    public static void validateNonEmptyInput(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(ViewErrorMessage.EMPTY.getMessage());
        }
    }

    public static void validateNumberInput(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(ViewErrorMessage.EMPTY.getMessage());
        }

        if (!isNumber(input)) {
            throw new IllegalArgumentException(ViewErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    private static boolean isEmpty(String input) {
        return Pattern.matches(ValidationRegex.EMPTY.getRegex(), input);
    }

    private static boolean isNumber(String input) {
        return Pattern.matches(ValidationRegex.NUMBER.getRegex(), input);
    }
}
