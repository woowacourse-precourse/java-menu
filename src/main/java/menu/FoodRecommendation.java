package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class FoodRecommendation {
    Map<Week, Category> categoryByWeek = new LinkedHashMap<>();
    List<Coach> coaches;

    public FoodRecommendation(List<Coach> coaches) {
        this.coaches = coaches;
        for(Week week : Week.values()) {
            Category category = Category.getCategoryByOrder(Randoms.pickNumberInRange(1, 5));
            categoryByWeek.put(week, category);
        }
    }

    public void recommend(List<Coach> coaches) {
        for (Week week : categoryByWeek.keySet()) {
            recommendByWeek(week);
        }
    }

    private void recommendByWeek(Week week) {
        for(Coach coach : coaches) {
            Category category = categoryByWeek.get(week);
            String food = category.getRandomFood();
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
