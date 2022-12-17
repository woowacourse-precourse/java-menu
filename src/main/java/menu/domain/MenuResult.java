package menu.domain;

import java.util.List;
import java.util.Map;

public class MenuResult {
    private final Coaches coaches;
    private final FoodCategoriesOfDay foodFoodCategoriesOfDay;

    public MenuResult(Coaches coaches, FoodCategoriesOfDay foodFoodCategoriesOfDay) {
        this.coaches = coaches;
        this.foodFoodCategoriesOfDay = foodFoodCategoriesOfDay;
    }

    public List<Coach> getCoaches() {
        return coaches.get();
    }

    public Map<Day, FoodCategory> getFoodCategories() {
        return foodFoodCategoriesOfDay.get();
    }
}
