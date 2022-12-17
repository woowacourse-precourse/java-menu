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
        if (isLessThanTwo(size)) {
            ExceptionMessage.NOT_INPUT_NAMES_LESS_THAN_TWO.throwException();
        }
        if (isMoreThanFive(size)) {
            ExceptionMessage.NOT_INPUT_NAMES_OVER_FIVE.throwException();
        }
    }

    private static boolean isLessThanTwo(int size) {
        return size < MINIMUM_NAME_SIZE;
    }

    private static boolean isMoreThanFive(int size) {
        return size > MAXIMUM_NAME_SIZE;
    }
}
