package menu.ui.input.exceptions;

import menu.ui.input.Repetitor;

public class Menus extends Repetitor {
    private static final String COMMA = ",";
    private static final int MININUM_UNAVAILABLE_MENU_SIZE = 0;
    private static final int MAXIMUM_UNAVAILABLE_MENU_SIZE = 2;
    private static final String UNAVAILABLE_MENU_SIZE_ERROR_MESSAGE = "[ERROR] 못먹는 메뉴는 0~2개만 입력 가능합니다";
    @Override
    protected String checkInputException(String input) throws IllegalArgumentException {
        Shared shared = new Shared();
        shared.sharedExceptionChecking(input);
        checkMenuNumber(input);

        return input;
    }

    private void checkMenuNumber(String input) throws IllegalArgumentException {
        String[] unavailableMenus = input.split(COMMA);
        int unavailableMenuSize = unavailableMenus.length;

        if (!(unavailableMenuSize >= MININUM_UNAVAILABLE_MENU_SIZE
                && unavailableMenuSize <= MAXIMUM_UNAVAILABLE_MENU_SIZE)) {
            throw new IllegalArgumentException(UNAVAILABLE_MENU_SIZE_ERROR_MESSAGE);
        }
    }
}
