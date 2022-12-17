package menu.utils.error.exception;

import menu.utils.error.ErrorMessages;

public class NonExistFoodException extends IllegalArgumentException {
    public NonExistFoodException() {
        super(ErrorMessages.NOT_EXIST_FOOD.getMessage());
    }
}
