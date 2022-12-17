package menu.domain;

import java.util.List;
import java.util.Map;

public class MenuResult {
    private List<Coach> coaches;
    private Map<Day, FoodCategory> foodCategories;

    public MenuResult(List<Coach> coaches, Map<Day, FoodCategory> foodCategories) {
        this.coaches = coaches;
        this.foodCategories = foodCategories;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public Map<Day, FoodCategory> getFoodCategories() {
        return foodCategories;
    }
}
