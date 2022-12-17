package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class FoodRecommender {
    private FoodRecommender() {
    }

    public static String pickRandomFood(List<String> foodsInCategory) {
        return Randoms.shuffle(foodsInCategory).get(0);
    }
}
