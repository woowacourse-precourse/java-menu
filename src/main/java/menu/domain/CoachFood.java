package menu.domain;

import java.util.Collections;
import java.util.List;

public class CoachFood {
    private final DislikeFood dislikeFood;
    private final RecommendedFood recommendedFood;

    public CoachFood(List<String> dislikeFoods) {
        this.dislikeFood = new DislikeFood(dislikeFoods);
        this.recommendedFood = new RecommendedFood();
    }

    //모든 요일에 대해서 반복 (월 ~ 금의 추천메뉴에 대해서 수행)
    public void updateRecommendedFood(List<String> foodsInCategory) {
        recommendedFood.pickRecommendedFood(foodsInCategory, dislikeFood.getDislikeFoods());
    }

    public List<String> getRecommendedFoods() {
        return Collections.unmodifiableList(recommendedFood.getFoods());
    }
}
