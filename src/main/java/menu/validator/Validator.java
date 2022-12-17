package menu.validator;

import menu.constans.Error;

public class Validator {
    public void validCoachNameInput(String names) {
        validCoachNamesSize(names);
        String[] split = names.split(",");
        for (String s : split) {
            validCoachNameLength(s);
        }
    }

    public void validCoachNameLength(String name) {
        name = name.trim();
        if (name.length() > 4 || name.length() < 2) {
            throw new IllegalArgumentException(Error.COACH_NAME_LENGTH.getMessage());
        }
    }

    public void validCoachNamesSize(String names) {
        String[] split = names.split(",");
        if (split.length < 2 || split.length > 5) {
            throw new IllegalArgumentException(Error.COACH_NAMES_SIZE.getMessage());
        }
    }


    public void validCantEatFoodSize(String foods) {
        String[] split = foods.split(",");
        if (split.length > 2) {
            throw new IllegalArgumentException(Error.CANT_EAT_FOOD_SIZE.getMessage());
        }
    }
}
