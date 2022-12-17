package menu.domain;

import menu.enums.Category;
import menu.utils.RandomUtils;

public class FoodRecommender {

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
            Category todayCategory = Category.selectCategoryByCode(RandomUtils.pickCategoryNumberInRandom());
            if (!coach.isOverTwoCountOfDuplicateCategory(todayCategory)) {
                return todayCategory;
            }
        }
    }

    private Food returnTodayFoodInCategory(Category todayCategory) {
        while (true) {
            Food todayFood = new Food(RandomUtils.pickFoodNameInShuffle(todayCategory.getFoods()));
            if (todayFood.getCategory().equals(todayCategory)) {
                return todayFood;
            }
        }
    }
}
