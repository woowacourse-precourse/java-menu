package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constant.Category;
import menu.constant.Weekday;

public class Recommender {

    private static final int COACH_SIZE_MINIMUM = 2;
    private static final int COACH_SIZE_MAXIMUM = 5;

    private final List<Coach> coaches;
    private final List<Category> recommendedCategories;

    public Recommender(List<Coach> coaches) {
        validateCoachesSize(coaches);
        this.coaches = coaches;
        this.recommendedCategories = new ArrayList<>();
    }

    private void validateCoachesSize(List<Coach> coaches) {
        if (coaches.size() < COACH_SIZE_MINIMUM) {
            throw new IllegalArgumentException("코치가 너무 적습니다");
        }
        if (coaches.size() > COACH_SIZE_MAXIMUM) {
            throw new IllegalArgumentException("코치가 너무 많습니다");
        }
    }

    public void recommend() {
        for (int i = 0; i < Weekday.length(); i++) {
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

    public List<Category> getRecommendedCategories() {
        return Collections.unmodifiableList(recommendedCategories);
    }
}
