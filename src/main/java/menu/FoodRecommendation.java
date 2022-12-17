package menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constants.CoachRules;
import menu.constants.Week;
import menu.domain.Category;
import menu.domain.Coach;
import menu.view.ErrorMessages;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FoodRecommendation {
    private final Map<Week, Category> categoryByWeek = new LinkedHashMap<>();
    private final List<Coach> coaches;

    public FoodRecommendation(List<Coach> coaches) {
        validate(coaches);
        this.coaches = coaches;
    }

    public void selectRandomCategory() {
        for (Week week : Week.values()) {
            categoryByWeek.put(week, getRandomCategory());
        }
    }

    private void validate(List<Coach> coaches) {
        if (coaches.size() < CoachRules.MIN_NUMBER_OF_COACHES.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.COACH_NUMBER_MIN.getMessage());
        }
        if (coaches.size() > CoachRules.MAX_NUMBER_OF_COACHES.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.COACH_NUMBER_MAX.getMessage());
        }
    }

    private int countContains(Category c) {
        return (int) categoryByWeek.values().stream()
                .filter(category -> category.getCategoryName().equals(c.getCategoryName()))
                .count();
    }

    private Category getRandomCategory() {
        Category category = Category.getCategoryByOrder(Randoms.pickNumberInRange(1, 5));
        while (countContains(category) > 1) {
            category = Category.getCategoryByOrder(Randoms.pickNumberInRange(1, 5));
        }
        return category;
    }

    public void recommend() {
        for (Week week : categoryByWeek.keySet()) {
            recommendByWeek(week);
        }
    }

    private void recommendByWeek(Week week) {
        for (Coach coach : coaches) {
            Category category = categoryByWeek.get(week);
            String food = category.getRandomFood();
            while (coach.contains(food) || coach.containsInedible(food)) {
                food = category.getRandomFood();
            }
            coach.recommendFood(food);
        }
    }

    public List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }

    public Map<Week, Category> getCategoryByWeek() {
        return Collections.unmodifiableMap(categoryByWeek);
    }
}
