package util;

import constant.ErrorLog;

public class Validator {




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
