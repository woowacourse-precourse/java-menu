package menu.view;

import static menu.constant.InputViewConstants.*;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Categories;
import menu.util.InputValidator;

public class InputView {

    public static String getCoachNames() {
        try {
            System.out.println(GET_COACH_NAMES);
            return InputValidator.validateCoachNames(Console.readLine());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getCoachNames();
        }
    }

    public static String getCantEatMenu(Categories categories, String coachName) {
        try {
            System.out.printf(GET_CANT_EAT_MENU, coachName);
            return InputValidator.validateCantEatMenu(categories, Console.readLine());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getCantEatMenu(categories, coachName);
        }
    }
}
