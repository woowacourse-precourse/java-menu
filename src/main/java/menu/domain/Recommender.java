package menu.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constant.Category;

public class Recommender {

    private final List<Coach> coaches;
    private final List<Category> recommendedCategories;

    public Recommender(List<Coach> coaches) {
        this.coaches = coaches;
        this.recommendedCategories = new ArrayList<>();
    }

    public void recommend() {
        for (int i = 0; i < 5; i++) {
            Category category = pickCategory();
            for (Coach coach : coaches) {
                coach.pickFrom(category);
            }
        }
    }

    private Category pickCategory() {
        Category category = Category.from(Randoms.pickNumberInRange(1, 5));
        while (isRecommendedTwice(category)) {
            category = Category.from(Randoms.pickNumberInRange(1, 5));
        }
        recommendedCategories.add(category);
        return category;
    }

    private boolean isRecommendedTwice(Category category) {
        long count = recommendedCategories.stream()
                .filter(element -> element.equals(category))
                .count();
        return count == 2;
    }
}
