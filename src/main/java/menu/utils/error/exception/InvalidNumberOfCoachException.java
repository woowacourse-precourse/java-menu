package menu.utils.error.exception;

import menu.utils.error.ErrorMessages;

public class InvalidNumberOfCoachException extends IllegalArgumentException {
    public InvalidNumberOfCoachException() {
        super(ErrorMessages.INVALID_NUMBER_OF_COACH.getMessage());
    }
}
