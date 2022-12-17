package menu.domain;

import java.util.List;
import java.util.Map;

public class MenuResult {
    private final Coaches coaches;
    private final Map<Day, FoodCategory> foodCategories;

    public MenuResult(Coaches coaches, Map<Day, FoodCategory> foodCategories) {
        this.coaches = coaches;
        this.foodCategories = foodCategories;
    }

    public List<Coach> getCoaches() {
        return coaches.get();
    }

    public Map<Day, FoodCategory> getFoodCategories() {
        return foodCategories;
    }
}
