package util;

import constant.ErrorLog;

public class Validator {
    private static final String NUMBER_REGEX = "^[0-9]{1,9}$"

    public static void validatePositiveInteger(String string) {
        if (!string.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ErrorLog.NOT_NUMBER_INPUT_EXCEPTION.getLog());
        }
    }

    public static void validateProductForm(String string) {
        if (!string.matches("")) {
            throw new IllegalArgumentException(ErrorLog.INVALID_FORM_EXCEPTION.getLog());
        }
    }

    public static void validateNotZero(int number) {
        if (number == 0) {
            throw new IllegalArgumentException(ErrorLog.ZERO_NUMBER_EXCEPTION.getLog());
        }
    }
}
