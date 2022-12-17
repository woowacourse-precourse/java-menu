package util;

import java.util.List;

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

    public static void validateCoachName(List<String> coachNames) {
        coachNames.forEach(name -> {if (name.length() < 2 || name.length() > 4) {
        throw new IllegalArgumentException(ErrorLog.INVALID_NAME.getLog());}
        });
    }
}
