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
        if (menuByCoach.isEmpty()) {
            return false;
        }
        List<String> recommendedMenus = menuByCoach.get(coachName);
        return recommendedMenus.contains(menuName);
    }

    public void recordCategory(Category category) {
        categories.add(category);
    }

    public void recordMenuByCoach(String menu, String coach) {
        List<String> recommendedMenus = addAndGetMenus(menu, coach);
        menuByCoach.put(coach, recommendedMenus);
    }

    private List<String> addAndGetMenus(String menu, String coach) {
        List<String> recommendedMenus;
        if (menuByCoach.containsKey(coach)) {
            recommendedMenus = menuByCoach.get(coach);
            recommendedMenus.add(menu);
            return recommendedMenus;
        }
        recommendedMenus = new ArrayList<>();
        recommendedMenus.add(menu);
        return recommendedMenus;
    }

    public Map<String, List<String>> getMenuByCoach() {
        return menuByCoach;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
