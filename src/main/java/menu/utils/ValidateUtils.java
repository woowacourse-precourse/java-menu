package menu.utils;

import menu.utils.constants.ErrorMessage;
import menu.utils.constants.NumberConstants;

public class ValidateUtils {
    public static void isValidCoachCount(String[] names){
        if (!((names.length >= NumberConstants.MIN_CREW_LIST.getValue()) && (names.length <=NumberConstants.MAX_CREW_LIST.getValue()))){
            throwIllegalArgumentException(ErrorMessage.NOT_VALID_COACH_COUNT.getMessage());
        }
    }

    public static void isValidBanFoodCount(String[] foods){
        if(foods.length > NumberConstants.MAX_BAN_FOOD_LIST.getValue()){
            throwIllegalArgumentException(ErrorMessage.NOT_VALID_FOOD_BAN_COUNT.getMessage());
        }
    }

    private static void throwIllegalArgumentException(String message) throws IllegalArgumentException{
        throw new IllegalArgumentException(message);
    }
}
