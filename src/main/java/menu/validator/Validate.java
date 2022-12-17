package menu.validator;

import menu.domain.ValidMenus;

public class Validate {

    private static final String DIVIDE = ",";

    public static void coachName(String coachName) {
        int nameLength = coachName.length();
        if (!(2 <= nameLength && nameLength <= 4)) {
            throw new IllegalArgumentException(ErrorMessages.ERROR.toString() + ErrorMessages.INVALID_COACH);
        }
    }

    public static void menu(String menuName) {
        ValidMenus.findMenuByName(menuName);
    }
}
