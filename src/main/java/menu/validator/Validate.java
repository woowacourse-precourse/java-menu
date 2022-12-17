package menu.validator;

import menu.ValidMenus;

public class Validate {

    public static void coachName(String coachName) {
        int nameLength = coachName.length();
        if (!(2 <= nameLength && nameLength <= 4)) {
            throw new IllegalArgumentException(ErrorMessages.ERROR.toString() + ErrorMessages.INVALID_COACH);
        }
    }

    public static ValidMenus menu(String menuName) {
        for (ValidMenus validMenu : ValidMenus.values()) {
            if (validMenu.getName().equals(menuName)) {
                return validMenu;
            }
        }
        throw new IllegalArgumentException(ErrorMessages.ERROR.toString() + ErrorMessages.INVALID_MENU);
    }
}
