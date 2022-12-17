package menu.validator;

import menu.domain.FoodRepository;
import menu.message.ErrorMessage;

public class InputValidator {
    private static final int minNameLength = 2;
    private static final int maxNameLength = 4;
    private static final int minCoachCount = 2;
    private static final int maxCoachCount = 5;
    private static final int maxInedibleFoodCount = 2;

    public static void validateNameInput(String namesInput) {
        if (isContainingSpace(namesInput) || !isValidLengthNames(namesInput) || !isValidCoachCount(namesInput)) {
            throw new IllegalArgumentException(ErrorMessage.coachNameInputError.getMessage());
        }
    }

    private static boolean isContainingSpace(String namesInput) {
        return namesInput.contains(" ");
    }

    private static boolean isValidLengthNames(String namesInput) {
        String[] names = namesInput.split(",");
        for (String name : names) {
            if (name.length() < minNameLength || name.length() > maxNameLength) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidCoachCount(String namesInput) {
        String[] coaches = namesInput.split(",");
        if (coaches.length < minCoachCount || coaches.length > maxCoachCount) {
            return false;
        }
        return true;
    }

    public static void validateInedibleFoodsInput(String inedibleFoodsInput) {
        if (!isValidInedibleFoodsAmount(inedibleFoodsInput) || !isAllExisting(inedibleFoodsInput)) {
            throw new IllegalArgumentException(ErrorMessage.inedibleFoodInputError.getMessage());
        }
    }

    private static boolean isValidInedibleFoodsAmount(String inedibleFoodsInput) {
        if (inedibleFoodsInput == null) {
            return true;
        }
        if (isContainingSpace(inedibleFoodsInput)) {
            return false;
        }
        if (inedibleFoodsInput.split(",").length > maxInedibleFoodCount) {
            return false;
        }
        return true;
    }

    private static boolean isAllExisting(String inedibleFoodsInput) {
        if (inedibleFoodsInput.length() == 0) {
            return true;
        }
        String[] inedibleFoods = inedibleFoodsInput.split(",");
        for (String inedibleFood : inedibleFoods) {
            if (!FoodRepository.isExistingFood(inedibleFood)) {
                return false;
            }
        }
        return true;
    }
}
