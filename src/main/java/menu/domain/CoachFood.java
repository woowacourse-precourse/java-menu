package menu.domain;

import java.util.List;

public class CoachFood {
    private final DislikeFood dislikeFood;
    private final RecommendedFood recommendedFood;

    public CoachFood(List<String> dislikeFoods) {
        this.dislikeFood = new DislikeFood(dislikeFoods);
        this.recommendedFood = new RecommendedFood();
    }

}
