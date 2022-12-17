package menu.view.utils;

import menu.repository.Menu;

import java.util.List;

import static menu.constant.Constants.*;

public class Validators {

    public static void validateForInvalidRangeOfCoachName(List<String> names) {

        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).length() < 2 || names.get(i).length() > 4) {
                throw new IllegalArgumentException(ERROR_MESSAGE + COACH_NAME_INVALID_RANGE_ERROR_MESSAGE);
            }
        }
    }

    public static void validateForInvalidRangeOfCoachCount(int size) {
        if (size < 2) {
            throw new IllegalArgumentException(ERROR_MESSAGE + COACH_INVALID_RANGE_ERROR_MESSAGE_OVER_TWO);
        } else if (size > 5) {
            throw new IllegalArgumentException(ERROR_MESSAGE + COACH_INVALID_RANGE_ERROR_MESSAGE_UNDER_FIVE);
        }
    }

    public static void validateForOverCountEatingMenu(int size) {
        if (size > 2) {
            throw new IllegalArgumentException(ERROR_MESSAGE + CANT_EATING_COUNT_MESSAGE_OVER_TWO);
        }
    }

    public static void validateForFoodName(List<String> foodNames) {
        for (int i = 0; i < foodNames.size(); i++) {
            if (Menu.getCategoryNum(foodNames.get(i)) == -1) {
                throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_FOOD_NAME_ERROR_MESSAGE);
            }
        }

    }

}
