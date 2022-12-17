package menu.util;

import menu.constant.ExceptionConstants;
import menu.constant.MenuConstants;

import java.util.List;

public class Validator {

    public static void validateNumberOfCoaches(int numberOfCoaches) {
        if (numberOfCoaches < MenuConstants.MINIMUM_NUMBER_OF_COACHES) {
            throw new IllegalArgumentException(ExceptionConstants.NOT_ENOUGH_COACH.getMessage());
        }
        if (MenuConstants.MAXIMUM_NUMBER_OF_COACHES < numberOfCoaches) {
            throw new IllegalArgumentException(ExceptionConstants.TOO_MANY_COACHES.getMessage());
        }
    }

    public static void validateCoachNameLength(int coachNameLength) {
        if (coachNameLength < MenuConstants.MINIMUM_COACH_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionConstants.TOO_SHORT_NAME.getMessage());
        }
        if (MenuConstants.MAXIMUM_COACH_NAME_LENGTH < coachNameLength) {
            throw new IllegalArgumentException(ExceptionConstants.TOO_LONG_NAME.getMessage());
        }
    }

    public static void validateNumberOfInedibleMenus(int numberOfInedibleMenus) {
        if (MenuConstants.MAXIMUM_NUMBER_OF_INEDIBLE_MENUS < numberOfInedibleMenus) {
            throw new IllegalArgumentException(ExceptionConstants.TOO_MANY_MENUS.getMessage());
        }
    }

    public static void validateDuplication(String input) {
        List<String> splittedInput = List.of(input.split(MenuConstants.DELIMITER));
        if (splittedInput.size() != splittedInput.stream()
                .distinct()
                .count()) {
            throw new IllegalArgumentException(ExceptionConstants.DUPLICATION.getMessage());
        }
    }
}
