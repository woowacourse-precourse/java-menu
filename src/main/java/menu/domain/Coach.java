package menu.domain;

import menu.enums.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static menu.utils.ErrorMessage.*;

public class Coach {
    private final String name;
    private List<String> doNotEatFoods = new ArrayList<>();
    private List<Food> recommendationFoods = new ArrayList<>();

    public Coach(String name) {
        validateNameRange(name);
        this.name = name;
    }

    private void validateNameRange(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(COACH_NAME_NOT_RANGE);
        }
    }

    public void addCoachDoNotEatFood(String foods) {
        String[] splitNames = foods.split(",");
        validateFoodsCount(splitNames);
        for (String foodName : splitNames) {
            validateValidName(foodName.trim());
            validateDuplicateFood(foodName.trim());
            doNotEatFoods.add(foodName);
        }
    }

    private void validateFoodsCount(String[] splitNames) {
        if (splitNames.length > 2) {
            throw new IllegalArgumentException(FOODS_NAMES_COUNT);
        }
    }

    private void validateValidName(String foodName) {
        Category.selectCategoryByFood(foodName);
    }

    private void validateDuplicateFood(String foodName) {
        for (String food : doNotEatFoods) {
            if (food.equals(foodName)) {
                doNotEatFoods.clear();
                throw new IllegalArgumentException(DUPLICATE_FOOD_NAME);
            }
        }
    }

    public int categoryCount(Category category) {
        int count = 0;
        for (Food food : recommendationFoods) {
            if (food.getCategory().equals(category)) {
                count++;
            }
        }
        return count;
    }

    public boolean isOverTwoCountOfDuplicateCategory(Category category) {
        return categoryCount(category) > 2;
    }

    public String getName() {
        return name;
    }

    public List<String> getDoNotEatFoods() {
        return doNotEatFoods;
    }
}