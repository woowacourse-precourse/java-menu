package menu.util;

import menu.message.ErrorMessage;

public class Validator {
    private static final String NAME_OR_COMMA = "^[가-힣,]*$";
    private static final int MINIMUM_NUMBER_OF_COACH = 2;
    private static final int MAXIMUM_NUMBER_OF_COACH = 5;
    private static final int MAXIMUM_NUMBER_OF_DISLIKE_FOOD = 2;

    public static void validateCoachNamesInput(String input) {
        if (!containsOnlyCommaOrName(input)) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_INPUT_FORMAT);
        }

        String[] coaches = input.split(Constant.INPUT_DELIMITER);

        if (isLessThanMinimumNumberOfCoach(coaches)) {
            throw new IllegalArgumentException(ErrorMessage.LESS_THAN_MINIMUM_NUMBER_OF_COACH);
        }
        if (isOverMaximumNumberOfCoach(coaches)) {
            throw new IllegalArgumentException(ErrorMessage.OVER_MAXIMUM_NUMBER_OF_COACH);
        }
    }

    public static void validateDislikeFoodsInput(String input) {
        if (!containsOnlyCommaOrName(input)) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_INPUT_FORMAT);
        }

        String[] foods = input.split(Constant.INPUT_DELIMITER);

        if (isOverMaximumNumberOfDislikeFood(foods)) {
            throw new IllegalArgumentException(ErrorMessage.OVER_MAXIMUM_NUMBER_OF_DISLIKE_FOOD);
        }
    }

    private static boolean containsOnlyCommaOrName(String input) {
        return input.matches(NAME_OR_COMMA);
    }

    private static boolean isLessThanMinimumNumberOfCoach(String[] coaches) {
        return coaches.length < MINIMUM_NUMBER_OF_COACH;
    }

    private static boolean isOverMaximumNumberOfCoach(String[] coaches) {
        return coaches.length > MAXIMUM_NUMBER_OF_COACH;
    }

    private static boolean isOverMaximumNumberOfDislikeFood(String[] foods) {
        return foods.length > MAXIMUM_NUMBER_OF_DISLIKE_FOOD;
    }
}
