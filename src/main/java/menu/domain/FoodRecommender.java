package menu.domain;

import menu.enums.Category;
import menu.utils.RandomUtils;

public class FoodRecommender {

    public Category recommendCategory(Coach coach) {
        Category todayCategory = getValidCategory(coach);
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
