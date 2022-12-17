package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class MenuRecommender {
    private List<Category> categoryHistory = new ArrayList<>();
    private List<Coach> coaches;
    private static final List<Category> CATEGORIES = Arrays.asList(Category.values());

    public MenuRecommender(List<Coach> coaches) {
        this.coaches = coaches;
        planCategory();
    }

    public List<Map<Coach, List<String>>> getRecommendationResult() {
        List<Map<Coach, List<String>>> result = new ArrayList<>();

        for (Coach coach : coaches) {
            result.add(planSingleCoach(coach));
        }

        return result;
    }

    private Map<Coach, List<String>> planSingleCoach(Coach coach) {
        Map<Coach, List<String>> singleCoach = new HashMap<>();
        List<String> menus = new ArrayList<>();

        for (Category category : categoryHistory) {
            menus.add(recommendMenu(category, coach));
        }
        singleCoach.put(coach, menus);
        return singleCoach;
    }

    private void planCategory() {
        for (int day = 0; day < 5; day++) {
            categoryHistory.add(returnValidCategory());
        }
    }



    private Category returnValidCategory() {
        Category category = null;
        boolean inavailableCategory = true;
        while (inavailableCategory) {
            category = pickupCategory();
            inavailableCategory = validCategory(category);
        }

        return category;
    }

    private Category pickupCategory() {
        return CATEGORIES.get(Randoms.pickNumberInRange(1, 5));
    }

    private boolean validCategory(Category category) {
        return Collections.frequency(categoryHistory, category) < 3;
    }

    private String recommendMenu(Category category, Coach coach) {
        boolean inavailableMenu = true;
        String menu = null;

        while (inavailableMenu) {
            menu = Randoms.shuffle(category.getMenus()).get(0);
            inavailableMenu = coach.checkMenu(menu);
        }

        return menu;
    }
}
