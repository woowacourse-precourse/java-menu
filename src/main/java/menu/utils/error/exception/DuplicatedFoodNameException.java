package menu.utils.error.exception;

import menu.utils.error.ErrorMessages;

public class DuplicatedFoodNameException extends IllegalArgumentException {
    public DuplicatedFoodNameException() {
        super(ErrorMessages.DUPLICATED_FOOD_NAME.getMessage());
    }
}
