package menu.utils.error.exception;

import menu.utils.error.ErrorMessages;

public class InvalidCoachNameLength extends IllegalArgumentException {
    public InvalidCoachNameLength() {
        super(ErrorMessages.INVALID_COACH_NAME.getMessage());
    }
}
