package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.enums.Category;

public class EatingTeam {

    private static final int MON = 0;
    private static final int TUE = 1;
    private static final int WED = 2;
    private static final int THU = 3;
    private static final int FRI = 4;
    private static final int DAY_NUMBER = 5;
    private static final int MAXIMUM_CATEGORY_NUMBER = 2;

    private final List<Coach> members;
    private final List<Category> categories = new ArrayList<>(DAY_NUMBER);
    private final Map<Coach, FoodRepository> recommendedMenuToCoach
            = new HashMap<Coach, FoodRepository>();

    public EatingTeam(final List<Coach> members) {
        this.members = members;
        this.members.forEach(coach ->
                recommendedMenuToCoach.put(coach, new FoodRepository(List.of())));
    }

    public List<Coach> getMembers() {
        return Collections.unmodifiableList(members);
    }

    public Map<Coach, FoodRepository> getRecommendedMenuToCoach() {
        return recommendedMenuToCoach;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void isRecommendedMenu() {
        for (int i = 0; i < DAY_NUMBER; i++) {
            Category category = isRecommendedCategory();
            categories.add(category);
            recommendedMenuToCoach.keySet().forEach(coach -> isRecommendedMenu(coach, category));
        }
    }

    // 각 코치마다 메뉴 추천
    private void isRecommendedMenu(Coach coach, Category category) {
        String menu;
        do {
            menu = Recommender.recommendMenu(category);
        } while (!(isMenuCanEat(coach, menu) && isNotDuplicated(coach, menu)));
        recommendedMenuToCoach.get(coach).add(new Food(menu));
    }

    private Category isRecommendedCategory() {
        Category category;
        do {
            category = Recommender.recommendCategory();
        } while (isNotExceedCategoryNumber(category));
        return category;
    }

    private boolean isMenuCanEat(Coach coach, String menu) {
        boolean b = coach.canEat(menu);
        return b;
    }

    private boolean isNotDuplicated(Coach coach, String menu) {
        boolean b = !recommendedMenuToCoach.get(coach).contains(menu);
        return b;
    }

    private boolean isNotExceedCategoryNumber(Category otherCategory) {
        return categories.stream()
                .filter(category -> category.equals(otherCategory))
                .count()
                >= MAXIMUM_CATEGORY_NUMBER;
    }
}
