package menu.utils.error.exception;

import menu.utils.error.ErrorMessages;

public class InvalidInputArgument extends IllegalArgumentException {
    public InvalidInputArgument() {
        super(ErrorMessages.INPUT_CORRECT_DELIMITER.getMessage());
    }
}
