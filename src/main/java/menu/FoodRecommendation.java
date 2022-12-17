package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class FoodRecommendation {
    Map<Week, Category> categoryByWeek = new LinkedHashMap<>();
    List<Coach> coaches;

    public FoodRecommendation(List<Coach> coaches) {
        this.coaches = coaches;
        for (Week week : Week.values()) {
            categoryByWeek.put(week, getRandomCategory());
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
            while (coach.contains(food)) {
                food = category.getRandomFood();
            }
            coach.recommendFood(food);
        }
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public Map<Week, Category> getCategoryByWeek() {
        return Collections.unmodifiableMap(categoryByWeek);
    }
}
