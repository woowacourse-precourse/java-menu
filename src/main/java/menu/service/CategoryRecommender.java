package menu.service;

import static menu.domain.Category.getCategoryByIndex;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.domain.Category;

public class CategoryRecommender {

    private static final int SAME_CATEGORY_MAX_COUNT = 2;

    public Category pickOneCategory(List<Category> recommendedCategories) {
        Category category;
        while (true) {
            category = getCategoryByIndex(
                    Randoms.pickNumberInRange(1, Category.values().length));
            if (!isValidCategory(recommendedCategories, category)) {
                continue;
            }
            return category;
        }
    }

    private boolean isValidCategory(List<Category> recommendedCategories, Category category) {
        long count = recommendedCategories.stream().filter(c -> c.equals(category)).count();
        return count < SAME_CATEGORY_MAX_COUNT;
    }
}
