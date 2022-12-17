package menu.exception.menu;

import menu.exception.BaseException;

public class MenuNameDuplicationException extends BaseException {

    public static final String MENU_NAME_DUPLICATED = "메뉴 이름은 중복될 수 없습니다.";

    public MenuNameDuplicationException() {
        super(MENU_NAME_DUPLICATED);
    }
}
