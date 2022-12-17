package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constant.Category;
import menu.constant.Food;
import menu.constant.Weekday;
import menu.domain.vo.Name;

public class Recommender {

    private static final int COACH_SIZE_MINIMUM = 2;
    private static final int COACH_SIZE_MAXIMUM = 5;
    private static final int TWICE = 2;

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
            Category category = pickAvailableCategory();
            for (Coach coach : coaches) {
                coach.pickFrom(category);
            }
        }
    }

    private Category pickAvailableCategory() {
        Category category = pickCategory();
        while (isRecommendedTwice(category)) {
            category = pickCategory();
        }
        recommendedCategories.add(category);
        return category;
    }

    private Category pickCategory() {
        return Category.from(Randoms.pickNumberInRange(1, 5));
    }

    private boolean isRecommendedTwice(Category category) {
        long count = recommendedCategories.stream()
                .filter(element -> element.equals(category))
                .count();
        return count == TWICE;
    }

    public List<Category> getRecommendedCategories() {
        return Collections.unmodifiableList(recommendedCategories);
    }

    public Map<Name, List<Food>> getRecommendations() {
        Map<Name, List<Food>> recommendedFoods = new HashMap<>();
        for (Coach coach : coaches) {
            recommendedFoods.put(coach.getName(), coach.getRecommendedFoods());
        }
        return Collections.unmodifiableMap(recommendedFoods);
    }
}
