package menu.domain.menu.exception;

import menu.domain.menu.exception.errorCode.MenuErrorCode;

public class MenuException extends IllegalArgumentException {

    private final MenuErrorCode errorCode;

    protected MenuException(MenuErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
