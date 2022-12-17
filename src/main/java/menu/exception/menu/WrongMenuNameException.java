package menu.exception.menu;

import menu.exception.BaseException;

public class WrongMenuNameException extends BaseException {

    public static final String MENU_NAME_NOT_FOUND = "존재하지 않는 메뉴입니다.";

    public WrongMenuNameException() {
        super(MENU_NAME_NOT_FOUND);
    }
}
