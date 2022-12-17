package menu.domain;

import java.util.List;

public class DislikeFood {
    private final List<String> foods;

    public DislikeFood(List<String> dislikeFoods) {
        validate(dislikeFoods);
        this.foods = dislikeFoods;
    }

    public List<String> getDislikeFoods() {
        return this.foods;
    }

    private void validate(List<String> foods) {
        if (DislikeFoodCondition.isWrongDislikeFoodCount(foods.size())) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 음식은 0개 ~ 2개 사이여야 합니다.");
        }
        foods.forEach(InitialMenu::validateFoodInMenu);
    }
}
