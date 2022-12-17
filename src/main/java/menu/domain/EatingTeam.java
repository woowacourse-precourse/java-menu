package menu.domain;

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

    public void isRecommendedMenu() {
        for (int i = 0; i < DAY_NUMBER; i++) {
            recommendedMenuToCoach.keySet().forEach(this::isRecommendedMenu);
        }
    }

    // 각 코치마다 메뉴 추천
    private void isRecommendedMenu(Coach coach) {
        Category category;
        do {
            category = Recommender.recommendCategory();
        } while (isNotExceedCategoryNumber(coach, category));

        String menu;
        do {
            menu = Recommender.recommendMenu(category);
        } while (isMenuCanEat(coach, menu) && isNotDuplicated(coach, menu));
        recommendedMenuToCoach.get(coach).add(new Food(menu));
    }

    private boolean isMenuCanEat(Coach coach, String menu) {
        return coach.canEat(menu);
    }

    private boolean isNotDuplicated(Coach coach, String menu) {
        return !recommendedMenuToCoach.get(coach).contains(menu);
    }

    private boolean isNotExceedCategoryNumber(Coach coach, Category category) {
        return recommendedMenuToCoach.get(coach).foods().stream()
                .filter(food -> Category.from(food).equals(category))
                .count() >= MAXIMUM_CATEGORY_NUMBER;
    }
}
