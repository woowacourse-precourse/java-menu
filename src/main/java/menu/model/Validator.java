package menu.model;

import menu.view.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    private static final int NAME_MIN = 2;
    private static final int NAME_MAX = 4;
    private static final int COACH_MIN = 2;
    private static final int COACH_MAX = 5;
    private static final int FOOD_MIN = 0;
    private static final int FOOD_MAX = 2;

    public static void validateCoach(String input) {
        String[] coaches = input.split(",");
        validateLength(coaches);

        for (String name : coaches) {
            validateName(name);
        }
    }

    private static void validateLength(String[] coaches) {
        if (coaches.length < COACH_MIN) {
            throw new IllegalArgumentException(ErrorMessage.COACH_MIN.getMessage());
        }
        if (coaches.length > COACH_MAX) {
            throw new IllegalArgumentException(ErrorMessage.COACH_MAX.getMessage());
        }
    }

    private static void validateName(String name) {
        if (name.length() < NAME_MIN) {
            throw new IllegalArgumentException(ErrorMessage.NAME_MIN.getMessage());
        }
        if (name.length() > NAME_MAX) {
            throw new IllegalArgumentException(ErrorMessage.NAME_MAX.getMessage());
        }
    }
}
