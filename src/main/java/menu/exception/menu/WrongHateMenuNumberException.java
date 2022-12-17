package menu.exception.menu;

import static menu.validator.MenuValidator.HATE_MENU_MAX_NUM;
import static menu.validator.MenuValidator.HATE_MENU_MIN_NUM;

import menu.exception.BaseException;

public class WrongHateMenuNumberException extends BaseException {

    public static final String WRONG_HATE_MENU_NUMBER =
            "최소 " + HATE_MENU_MIN_NUM + "개, 최대 " + HATE_MENU_MAX_NUM + "개의 못 먹는 메뉴를 입력할 수 있습니다.";

    public WrongHateMenuNumberException() {
        super(WRONG_HATE_MENU_NUMBER);
    }
}