package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class FoodRecommendation {
    Map<Week, Category> map = new HashMap<>();

    public FoodRecommendation() {
        for(Week week : Week.values()) {
            Category category = Category.getCategoryByOrder(Randoms.pickNumberInRange(1, 5));
            map.put(week, category);
        }
    }
}
