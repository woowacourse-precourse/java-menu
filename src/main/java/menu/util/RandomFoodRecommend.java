package menu.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomFoodRecommend {
    public static String randomRecommendFood(List<String> foodNames) {
        List<String> shuffledFoodNames = Randoms.shuffle(foodNames);
        return shuffledFoodNames.get(shuffledFoodNames.size() - 1);
    }
}
