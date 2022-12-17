package menu.domain;

import menu.enums.Category;
import menu.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class FoodRecommender {
    private final List<String> menus;

    public FoodRecommender() {
        List<String> menus = new ArrayList<>();
        for (Category category : Category.values()) {
            menus.addAll(category.getFoods());
        }
        this.menus = menus;
    }

    public void recommendTodayFood(Coach coach) {
        Category todayCategory = getValidCategory(coach);
        String todayFood = RandomUtils.pickFoodNameInShuffle(menus);
        addValidTodayFood(coach, todayFood);
    }

    private void addValidTodayFood(Coach coach, String todayFood) {
        while (true) {
            if (coach.addTodayFood(new Food(todayFood))) {
                return;
            }
        }
    }

    private Category getValidCategory(Coach coach) {
        while (true) {
            Category todayCategory = RandomUtils.pickCategoryInRandom();
            if (!coach.isOverTwoCountOfDuplicateCategory(todayCategory)) {
                return todayCategory;
            }
        }
    }
}
