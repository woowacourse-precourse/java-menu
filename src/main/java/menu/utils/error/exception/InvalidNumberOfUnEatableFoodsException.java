package menu.utils.error.exception;

import menu.utils.error.ErrorMessages;

public class InvalidNumberOfUnEatableFoodsException extends IllegalArgumentException {
    public InvalidNumberOfUnEatableFoodsException() {
        super(ErrorMessages.INVALID_NUMBER_OF_UNEATABLE_FOODS.getMessage());
    }
}
