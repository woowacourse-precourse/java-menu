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

    public void validateCoachNameLength(int coachNameLength) {
        if (coachNameLength < MenuConstants.MINIMUM_COACH_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionConstants.TOO_SHORT_NAME.getMessage());
        }
        if (MenuConstants.MAXIMUM_COACH_NAME_LENGTH < coachNameLength) {
            throw new IllegalArgumentException(ExceptionConstants.TOO_LONG_NAME.getMessage());
        }
    }

    public void validateNumberOfInedibleMenus(int numberOfInedibleMenus) {
        if (MenuConstants.MAXIMUM_NUMBER_OF_INEDIBLE_MENUS < numberOfInedibleMenus) {
            throw new IllegalArgumentException(ExceptionConstants.TOO_MANY_MENUS.getMessage());
        }
    }
}
