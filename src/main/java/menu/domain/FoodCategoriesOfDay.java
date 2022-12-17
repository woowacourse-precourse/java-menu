package menu.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FoodCategoriesOfDay {
    private final Map<Day, FoodCategory> foodCategories;

    public FoodCategoriesOfDay() {
        this.foodCategories = new HashMap<>();
    }


    public long getCategoryCount(FoodCategory category) {
        return foodCategories.values()
                .stream()
                .filter(foodCategory -> foodCategory == category)
                .count();
    }

    public void put(Day day, FoodCategory category) {
        foodCategories.put(day, category);
    }

    public Map<Day, FoodCategory> get() {
        return Collections.unmodifiableMap(foodCategories);
    }
}
