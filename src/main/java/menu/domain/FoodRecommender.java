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

    public void repeatThisWeekFood(Coach coach) {
        for (int i = 0; i < 6; i++) {
            recommendTodayFood(coach);
        }
    }

    public void recommendTodayFood(Coach coach) {
        Category todayCategory = getValidCategory(coach);
        addValidTodayFood(coach, todayCategory);
    }

    private void addValidTodayFood(Coach coach, Category todayCategory) {
        while (true) {
            Food todayFood = returnTodayFoodInCategory(todayCategory);
            if (coach.addTodayFood(todayFood)) {
                break;
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

    private Food returnTodayFoodInCategory(Category todayCategory) {
        while (true) {
            Food todayFood = new Food(RandomUtils.pickFoodNameInShuffle(menus));
            if (todayFood.getCategory().equals(todayCategory)) {
                return todayFood;
            }
        }
    }
}
