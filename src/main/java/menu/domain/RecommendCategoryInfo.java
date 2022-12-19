package menu.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class RecommendCategoryInfo {
    private final EnumMap<CategoryMenu, Integer> categoryHistory = new EnumMap<>(CategoryMenu.class);
    private final List<CategoryMenu> dayRecommendedCategoryInfo = new ArrayList<>();

    private final int MAX_CATEGORY_MEAL_COUNT = 2;

    public boolean isPossibleCategory(CategoryMenu category) {
        Integer mealCount = categoryHistory.getOrDefault(category, 0);
        return mealCount < MAX_CATEGORY_MEAL_COUNT;
    }

    public void mealCategory(CategoryMenu categoryMenu) {
        categoryHistory.put(categoryMenu, categoryHistory.getOrDefault(categoryMenu, 0) + 1);
    }

    public void saveCategoryInfoPerDay(CategoryMenu category) {
        dayRecommendedCategoryInfo.add(category);
    }

    public List<CategoryMenu> getCategoryRecommendedInfo() {
        return new ArrayList<>(dayRecommendedCategoryInfo);
    }
}
