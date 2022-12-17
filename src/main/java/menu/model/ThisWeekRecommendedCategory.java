package menu.model;

import java.util.List;

public class ThisWeekRecommendedCategory {

    List<Category> categories;

    public void updateRecommendCategory(Category recommendedCategory) {
        categories.add(recommendedCategory);
    }
}
