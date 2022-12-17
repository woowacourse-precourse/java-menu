package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MenuRecommender {
    private List<Category> categoryHistory = new ArrayList<>();
    private List<Coach> coaches;
    private static final List<Category> CATEGORIES = Arrays.asList(Category.values());

    public MenuRecommender(List<Coach> coaches) {
        this.coaches = coaches;
        planCategory();
    }

    public List<List<String>> getRecommendationResult() {
        List<List<String>> result = new ArrayList<>();

        for (Coach coach : coaches) {
            result.add(planSingleCoach(coach));
        }

        return result;
    }

    public List<Category> getCategoryHistory() {
        return categoryHistory;
    }

    private List<String> planSingleCoach(Coach coach) {
        List<String> singleCoach = new ArrayList<>();
        singleCoach.add(coach.getName());

        for (Category category : categoryHistory) {
            singleCoach.add(recommendMenu(category, coach));
        }

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
            inavailableCategory = !(validCategory(category));
        }

        return category;
    }

    private Category pickupCategory() {
        return CATEGORIES.get(Randoms.pickNumberInRange(0, CATEGORIES.size() - 1));
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
