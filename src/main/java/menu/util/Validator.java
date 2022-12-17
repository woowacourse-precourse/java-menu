package menu.util;

import static menu.message.ErrorMessage.INCORRECT_INPUT_FORMAT;
import static menu.message.ErrorMessage.LESS_THAN_MINIMUM_NUMBER_OF_COACH;
import static menu.message.ErrorMessage.OVER_MAXIMUM_NUMBER_OF_COACH;

public class Validator {
    private static final String NAME_OR_COMMA = "^[가-힣,]*$";

    public static void validateCoachNamesInput(String input) {
        if (!containsOnlyCommaOrName(input)) {
            throw new IllegalArgumentException(INCORRECT_INPUT_FORMAT);
        }

        String[] coaches = input.split(",");
        if (isLessThanMinimumNumberOfCoach(coaches)) {
            throw new IllegalArgumentException(LESS_THAN_MINIMUM_NUMBER_OF_COACH);
        }
        if (isOverMaximumNumberOfCoach(coaches)) {
            throw new IllegalArgumentException(OVER_MAXIMUM_NUMBER_OF_COACH);
        }
    }

    private static boolean containsOnlyCommaOrName(String input) {
        return input.matches(NAME_OR_COMMA);
    }

    private static boolean isLessThanMinimumNumberOfCoach(String[] coaches) {
        return coaches.length < 2;
    }

    private static boolean isOverMaximumNumberOfCoach(String[] coaches) {
        return coaches.length > 5;
    }
}
