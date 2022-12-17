package menu.util;

import static menu.constant.ExceptionConstants.*;

import java.util.Arrays;
import java.util.List;
import menu.domain.Categories;

public class InputValidator {





    public static String validateCoachNames(String input) {
        List<String> coachNames = Arrays.asList(input.split(","));
        if (coachNames.size() < 2 || coachNames.size() > 5) {
            throw new IllegalArgumentException(COACH_NAMES_ERROR_1);
        }
        if (!isCoachNameSizeTwoToFour(coachNames)) {
            throw new IllegalArgumentException(COACH_NAMES_ERROR_2);
        }
        return input;
    }

    private static boolean isCoachNameSizeTwoToFour(List<String> coachNames) {
        for (String coachName : coachNames) {
            if (coachName.length() < 2 || coachName.length() > 4) {
                return false;
            }
        }
        return true;
    }

    public static String validateCantEatMenu(Categories categories, String input) {
        List<String> cantEatMenu = Arrays.asList(input.split(","));
        cantEatMenu.stream().forEach(categories::validateExistMenu);
        if (cantEatMenu.size() > 2) {
            throw new IllegalArgumentException(CANT_EAT_MENU_ERROR);
        }
        return input;
    }
}
