package menu.domain.history;

import menu.domain.category.Category;

import java.util.*;

public class RecommendHistory {

    private static final int CATEGORY_MAX = 2;
    private final List<Category> categories;
    private final Map<String, List<String>> menuByCoach;

    public RecommendHistory() {
        this.categories = new ArrayList<>();
        this.menuByCoach = new LinkedHashMap<>();
    }

    public boolean canRecommend(Category category) {
        return isExcessMaximumRecommend(category);
    }

    private boolean isExcessMaximumRecommend(Category category) {
        return Collections.frequency(categories, category) <= CATEGORY_MAX;
    }

    public boolean canRecommend(String coachName, String menuName) {
        return !hasRecommendedMenu(coachName, menuName);
    }

    private boolean hasRecommendedMenu(String coachName, String menuName) {
        if (menuByCoach.size() == 0) {
            return false;
        }
        List<String> recommendedMenus = menuByCoach.get(coachName);
        return recommendedMenus.contains(menuName);
    }
}
