package menu.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MenuCategoriesOfDay {
    private final Map<Day, MenuCategory> foodCategories;

    public MenuCategoriesOfDay() {
        this.foodCategories = new HashMap<>();
    }


    public long getCategoryCount(MenuCategory category) {
        return foodCategories.values()
                .stream()
                .filter(foodCategory -> foodCategory == category)
                .count();
    }

    public void put(Day day, MenuCategory category) {
        foodCategories.put(day, category);
    }

    public Map<Day, MenuCategory> get() {
        return Collections.unmodifiableMap(foodCategories);
    }
}
