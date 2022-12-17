package menu.domain.menu.exception;

import menu.domain.menu.exception.errorCode.MenuErrorCode;

public class CategoryNotFoundException extends MenuException {

    public CategoryNotFoundException() {
        super(MenuErrorCode.CATEGORY_NOT_FOUND);
    }
}
