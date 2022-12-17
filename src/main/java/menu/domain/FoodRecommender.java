package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class FoodRecommender {
    private final List<Coach> coaches;
    private List<FoodCategory> foodCategories;

    public FoodRecommender(List<Coach> coaches) {
        validateSize(coaches);
        this.coaches = coaches;
        foodCategories = new ArrayList<>();
    }

    private void validateSize(List<Coach> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException("코치는 2~5명 사이만 입력 가능합니다.");
        }
    }

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
