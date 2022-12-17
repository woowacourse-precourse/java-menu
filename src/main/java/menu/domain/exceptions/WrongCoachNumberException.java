package menu.domain.exceptions;

import menu.utils.Constants;

public class WrongCoachNumberException extends IllegalArgumentException {

    public WrongCoachNumberException() {
        super(Constants.ERROR_WRONG_COACH_NUMBER);
    }

}
