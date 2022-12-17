package menu.utils;

import menu.utils.constants.ErrorMessage;

public class ValidateUtils {
    public static void isValidCoachCount(String[] names){
        if (!((names.length >= 2) && (names.length <=5))){
            throwIllegalArgumentException(ErrorMessage.NOT_VALID_COACH_COUNT.getMessage());
        }
    }
    private static void throwIllegalArgumentException(String message) throws IllegalArgumentException{
        throw new IllegalArgumentException(message);
    }
}
