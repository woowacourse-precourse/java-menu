package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class FoodRecommendation {
    Map<Week, Category> map = new HashMap<>();
    Map<Coach, List<String>> recommend = new HashMap<>();

    public FoodRecommendation() {
        for(Week week : Week.values()) {
            Category category = Category.getCategoryByOrder(Randoms.pickNumberInRange(1, 5));
            map.put(week, category);
        }
    }

    public void recommend(Coach coach) {
        List<String> foods = new ArrayList<>();
        for (Week week : map.keySet()) {
            Category category = map.get(week);
            String food = category.getRandomFood();
            foods.add(food);
        }
        recommend.put(coach, foods);
    }

    public Map<Coach, List<String>> getRecommend() {
        return Collections.unmodifiableMap(recommend);
    }
}
