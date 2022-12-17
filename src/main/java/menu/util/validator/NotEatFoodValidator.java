package menu.util.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.util.constants.ExceptionMessage;

public class NotEatFoodValidator {

    private static final String SEPARATOR = ",";

    private static final int NOT_EAT_FOOD_MINIMUM_NUMBER = 0;
    private static final int NOT_EAT_FOOD_MAXIMUM_NUMBER = 2;

    public static void validateNotEatFoods(String notEatFoods) {
        List<String> notEatFoodNames = Arrays.asList(notEatFoods.split(SEPARATOR,-1));
        notEatFoodNames.stream()
                .forEach(foodName -> validateNotEatFoodName(foodName));
        validateNotEatFoodNumber(notEatFoodNames);
        validateDuplicateNotEatFoods(notEatFoodNames);
    }

    private static void validateNotEatFoodName(String foodName) {
        if (foodName.equals("") || foodName == null) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_EAT_FOOD_NOT_EMPTY);
        }
    }

    private static void validateNotEatFoodNumber(List<String> notEatFoods) {
        if (!(notEatFoods.size() >= NOT_EAT_FOOD_MINIMUM_NUMBER && notEatFoods.size() <= NOT_EAT_FOOD_MAXIMUM_NUMBER)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_EAT_FOOD_NUMBER);
        }
    }

    private static void validateDuplicateNotEatFoods(List<String> notEatFoods) {
        Set<String> distinct = new HashSet<>(notEatFoods);
        if (notEatFoods.size() != distinct.size()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_EAT_FOOD_DUPLICATE);
        }
    }

}
