package menu;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class FoodRecommender {
    private int dayCount;
    private Map<String, Integer> categoryCount;
    private Set<String> menuCheck;

    FoodRecommender() {
        dayCount = 0;
        categoryCount = new HashMap<>();
        for (String categoryI : FoodPool.category) {
            categoryCount.put(categoryI, 0);
        }
        menuCheck = new HashSet<>();
    }

    public String pickCategory() {
        String newCategory;
        while (true) {
            newCategory = FoodPool.category[Randoms.pickNumberInRange(1, 5) - 1];
            if (checkCategory(newCategory)) break;
        }
        categoryCount.replace(newCategory, categoryCount.get(newCategory) + 1);
        return newCategory;
    }

    private boolean checkCategory(String newCategory) {
        return categoryCount.get(newCategory) <= 1;
    }
}
