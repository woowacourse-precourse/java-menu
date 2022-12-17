package menu.validator;

import java.util.List;
import menu.exception.WrongHateMenuNumberException;

public class MenuValidator {

    public static final int HATE_MENU_MIN_NUM = 0;
    public static final int HATE_MENU_MAX_NUM = 2;

    public static void validateHateMenu(List<String> menuNames) {
        if (!verifyMenuNumber(menuNames)) {
            throw new WrongHateMenuNumberException();
        }
    }

    private static boolean verifyMenuNumber(List<String> menuNames) {
        return menuNames.size() >= HATE_MENU_MIN_NUM && menuNames.size() <= HATE_MENU_MAX_NUM;
    }
}
