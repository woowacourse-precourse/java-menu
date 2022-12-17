package menu.validation;

import menu.constants.ExceptionMessage;

import java.util.Arrays;
import java.util.List;

public class InputValidation {
    private static final String COMMA = ",";
    private static final int MINIMUM_NAME_SIZE = 2;
    private static final int MAXIMUM_NAME_SIZE = 5;

    public static List<String> validateCoachesName(String names) {
        isExist(names);
        List<String> coaches = toList(names);
        isSizeBetween2And5(coaches.size());
        return coaches;
    }

    private static void isExist(String inputValue) {
        if (inputValue.isEmpty()) {
            ExceptionMessage.NONE_INPUT.throwException();
        }
    }

    private static List<String> toList(String names) {
        return Arrays.asList(names.split(COMMA));
    }

    private static void isSizeBetween2And5(int size) {
        if (!isBetween2And5(size)) {
            ExceptionMessage.NOT_INPUT_NAMES_BETWEEN_2AND5.throwException();
        }
    }

    private static boolean isBetween2And5(int size) {
        return MINIMUM_NAME_SIZE <= size && size < MAXIMUM_NAME_SIZE;
    }
}
