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

    public void updateRecommendedFood(List<String> foodsInCategory) {
        recommendedFood.pickRecommendedFood(foodsInCategory, dislikeFood.getDislikeFoods());
    }

    public List<String> getRecommendedFoods() {
        return Collections.unmodifiableList(recommendedFood.getFoods());
    }
}
