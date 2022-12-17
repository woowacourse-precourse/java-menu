package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class FoodRecommender {

    private List<FoodCategory> foodCategories;

    private FoodCategory generateCategory() {
        FoodCategory category = FoodCategory.of(Randoms.pickNumberInRange(1, 5));
        if (getCategorySelectCount(category) == 2) {
            return generateCategory();
        }
        foodCategories.add(category);
        return category;
    }

    private long getCategorySelectCount(FoodCategory category) {
        return foodCategories.stream()
                .filter(foodCategory -> foodCategory == category)
                .count();
    }

}
