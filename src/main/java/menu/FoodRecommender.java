package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class FoodRecommender {
    private FoodRecommender() {
    }

    public static String pickRandomFood(List<String> categories) {
        return Randoms.shuffle(categories).get(0);
    }
}
