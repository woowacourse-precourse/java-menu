package menu.util;

import menu.constant.ExceptionConstants;
import menu.constant.MenuConstants;

public class Validator {

    public void validateNumberOfCoaches(int numberOfCoaches) {
        if (numberOfCoaches < MenuConstants.MINIMUM_NUMBER_OF_COACHES) {
            throw new IllegalArgumentException(ExceptionConstants.NOT_ENOUGH_COACH.getMessage());
        }
        if (MenuConstants.MAXIMUM_NUMBER_OF_COACHES < numberOfCoaches) {
            throw new IllegalArgumentException(ExceptionConstants.TOO_MANY_COACHES.getMessage());
        }
    }
}
