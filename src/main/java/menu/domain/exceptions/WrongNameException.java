package menu.domain.exceptions;

import menu.utils.Constants;

public class WrongNameException extends IllegalArgumentException {

    public WrongNameException() {
        super(Constants.ERROR_WRONG_NAME);
    }
}
