package menu.utils.error.exception;

import menu.utils.error.ErrorMessages;

public class DuplicatedCoachNameException extends IllegalArgumentException {
    public DuplicatedCoachNameException() {
        super(ErrorMessages.DUPLICATED_COACH_NAME.getMessage());
    }
}
