package menu.utils;

import menu.exception.MenuNameBlankException;
import menu.exception.TooManyMenusException;

import java.util.ArrayList;
import java.util.List;

public class MenusInputParser {
    private static final List<String> NO_MENU = new ArrayList<>();
    private static final int MAX_COUNT = 2;
    private static final String MENU_DELIMITER = ",";

    private static void validateFood(String food) {
        if (food.isBlank()) {
            throw new MenuNameBlankException();
        }
    }

    private static void validateMenus(List<String> menus) {
        int menuCount = menus.size();
        if (menuCount > MAX_COUNT) {
            throw new TooManyMenusException();
        }
    }

    private static List<String> getMenus(String input) {
        List<String> menus = new ArrayList<>();
        for (String menu : input.split(MENU_DELIMITER)) {
            validateFood(menu);
            menus.add(menu);
        }

        return menus;
    }

    public static List<String> parser(String input) {
        if (input.isBlank()) {
            return NO_MENU;
        }
        List<String> menus = getMenus(input);
        validateMenus(menus);

        return menus;
    }
}
