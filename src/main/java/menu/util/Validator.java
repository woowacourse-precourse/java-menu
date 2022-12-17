package menu.util;

import java.util.List;

import static menu.util.Constants.*;

public class Validator {

    public static void validateCoachNamesSize(List<String> names) {
        if (names.size() < MIN_NUMBER_OF_COACH || names.size() > MAX_NUMBER_OF_COACH) {
            throw new IllegalArgumentException(
                    String.format(NUMBER_OF_COACH_ERROR, MIN_NUMBER_OF_COACH, MAX_NUMBER_OF_COACH));
        }
    }

    public static void validateCoachNameLength(String name) {
        if (name.length() < MIN_LENGTH_OF_NAME || name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(
                    String.format(LENGTH_OF_NAME_ERROR, MIN_LENGTH_OF_NAME, MAX_LENGTH_OF_NAME)
            );
        }
    }

    public static void validateHateMenusSize(List<String> hateMenus) {
        if (hateMenus.size() < MIN_NUMBER_OF_HATE_MENU || hateMenus.size() > MAX_NUMBER_OF_HATE_MENU) {
            throw new IllegalArgumentException(
                    String.format(NUMBER_OF_HATE_MENU_ERROR, MIN_NUMBER_OF_HATE_MENU, MAX_NUMBER_OF_HATE_MENU)
            );
        }
    }

}
