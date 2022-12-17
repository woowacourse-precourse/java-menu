package menu.exception;

import menu.enums.ErrorMessage;
import menu.enums.MyValue;

import java.util.List;

public class InputException {
    public void validateCoachName(List<String> coachName) {
        for (String name : coachName) {
            if (name.length() < MyValue.NAME_MINIMUM_SIZE.getValue()
                    || name.length() > MyValue.NAME_MAXIMUM_SIZE.getValue()) {
                throw new IllegalArgumentException(ErrorMessage.NAME_OUT_OF_SIZE.getMessage());
            }
        }
    }

    public void validateCoachCount(List<String> coachName) {
        if (coachName.size() < MyValue.EAT_TOGETHER_MINIMUM_SIZE.getValue()
                || coachName.size() > MyValue.EAT_TOGETHER_MAXIMUM_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.EAT_TOGETHER_OUT_OF_RANGE.getMessage());
        }
    }

    public void validateDislikeFoodCount(List<String> dislikeFood) {
        if (dislikeFood.size() > MyValue.DISLIKE_FOOD_MAXIMUM_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.DISLIKE_FOOD_OUT_OF_SIZE.getMessage());
        }
    }
}
