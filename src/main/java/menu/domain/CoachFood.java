package menu.domain;

public class CoachFood {
    private final DislikeFood dislikeFood;
    private final RecommendedFood recommendedFood;

    public CoachFood() {
        this.dislikeFood = new DislikeFood();
        this.recommendedFood = new RecommendedFood();
    }
}
