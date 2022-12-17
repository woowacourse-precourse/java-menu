package menu.utils.validator;

import java.util.Arrays;
import menu.domain.Category;
import menu.utils.constants.Common;
import menu.utils.error.exception.DuplicatedFoodNameException;
import menu.utils.error.exception.InvalidInputArgument;
import menu.utils.error.exception.InvalidNumberOfUnEatableFoodsException;
import menu.utils.error.exception.NonExistFoodException;

public class UnEatableInputValidator implements InputValidator {
    @Override
    public void validate(String input) {
        String[] foods = input.split(DELIMITER);
        if (isNotValidNumberOfUnEatableFoods(foods)) {
            throw new InvalidNumberOfUnEatableFoodsException();
        }
        if (isNotExistFoodName(foods)) {
            throw new NonExistFoodException();
        }
        if (invalidArgument(input, foods)) {
            throw new InvalidInputArgument();
        }
        if (isDuplicatedFood(foods)) {
            throw new DuplicatedFoodNameException();
        }
    }

    private boolean invalidArgument(String input, String[] names) {
        return input.chars().filter(c -> c == DELIMITER_CHAR).count() + 1 != names.length;
    }

    private boolean isNotValidNumberOfUnEatableFoods(String[] split) {
        return split.length > Common.MAX_UNEATABLE_FOOD.getNumber();
    }

    private boolean isNotExistFoodName(String[] split) {
        for (String food : split) {
            if (isNotCategoryContainFood(food)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNotCategoryContainFood(String food) {
        for (Category category : Category.values()) {
            if (category.getMenus().contains(food)) {
                return false;
            }
        }
        return true;
    }

    private boolean isDuplicatedFood(String[] names) {
        return Arrays.stream(names).distinct().count() != names.length;
    }
}
