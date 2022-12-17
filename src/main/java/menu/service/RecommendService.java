package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;
import menu.domain.Coach;
import menu.domain.FoodCategory;
import menu.domain.Menu;

public class RecommendService {
    public static final int MIN_CATEGORY_NUM = 1;
    public static final int MAX_CATEGORY_NUM = 5;

    private static final Map<FoodCategory, Integer> categoryCounts = new HashMap<>();
    private static final Map<Coach, Menu> eatFoods = new HashMap<>();


    public FoodCategory recommendCategory() {
        try {
            return recommendCategory(getRandoms());
        } catch (IllegalStateException e) {
            return recommendCategory();
        }
    }

    private int getRandoms() {
        return Randoms.pickNumberInRange(MIN_CATEGORY_NUM, MAX_CATEGORY_NUM);
    }

    public FoodCategory recommendCategory(int randomNum) {
        FoodCategory category = getCategory(randomNum);
        Integer counts = categoryCounts.getOrDefault(category, 0);
        if (counts >= 2) {
            throw new IllegalStateException("이미 2번 추천되었습니다");
        }
        categoryCounts.put(category, counts + 1);
        return category;
    }

    private FoodCategory getCategory(int randomNum) {
        return FoodCategory.findByNumber(randomNum);
    }
}
