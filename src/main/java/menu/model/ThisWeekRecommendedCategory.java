package menu.model;

import java.util.Collections;
import java.util.List;

public class ThisWeekRecommendedCategory {

    private static final int MAX_RECOMMEND_CATEGORY_COUNT = 2;

    List<Category> categories;

    public void updateRecommendCategory(Category recommendedCategory) {
        categories.add(recommendedCategory);
    }

    public boolean isRecommendCategoryCountOverTwo(Category recommendedCategory) {
        int categoryCount = Collections.frequency(categories, recommendedCategory);
        return categoryCount > MAX_RECOMMEND_CATEGORY_COUNT;
    }

}
