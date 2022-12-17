package menu.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThisWeekRecommendedCategory {

    private static final int MAX_RECOMMEND_CATEGORY_COUNT = 2;
    private static final String CATEGORY_MESSAGE = "카테고리";

    List<Category> categories = new ArrayList<>();

    public void updateRecommendCategory(Category recommendedCategory) {
        categories.add(recommendedCategory);
    }

    public boolean isRecommendCategoryCountOverTwo(Category recommendedCategory) {
        String recommendCategoryName = recommendedCategory.getName();
        long categoryCount = categories.stream()
                .map(Category::getName)
                .filter(categoryName -> categoryName.equals(recommendCategoryName))
                .count();
        return categoryCount > MAX_RECOMMEND_CATEGORY_COUNT;
    }

    public List<String> getRecommendCategoriesForPrint() {
        List<String> recommendCategoriesForPrint = new ArrayList<>();
        recommendCategoriesForPrint.add(0, CATEGORY_MESSAGE);
        categories.forEach(category -> recommendCategoriesForPrint.add(category.getName()));
        return Collections.unmodifiableList(recommendCategoriesForPrint);
    }
}
