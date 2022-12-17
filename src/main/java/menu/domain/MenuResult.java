package menu.domain;

import java.util.List;
import java.util.Map;

public class MenuResult {
    private final Coaches coaches;
    private final MenuCategoriesOfDay foodMenuCategoriesOfDay;

    public MenuResult(Coaches coaches, MenuCategoriesOfDay foodMenuCategoriesOfDay) {
        this.coaches = coaches;
        this.foodMenuCategoriesOfDay = foodMenuCategoriesOfDay;
    }

    public List<Coach> getCoaches() {
        return coaches.get();
    }

    public Map<Day, MenuCategory> getFoodCategories() {
        return foodMenuCategoriesOfDay.get();
    }
}
