package menu.domain.exceptions;

import menu.utils.Constants;

public class WrongFoodNumberException extends IllegalArgumentException {

    public WrongFoodNumberException() {
        super(Constants.ERROR_WRONG_FOOD_NUMBER);
    }
}
