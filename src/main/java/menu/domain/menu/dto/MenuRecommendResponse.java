package menu.domain.menu.dto;

import java.util.List;
import menu.domain.menu.model.Coach;
import menu.domain.menu.model.Food;

public class MenuRecommendResponse {

    private final Coach coach;
    private final List<Food> foods;

    public MenuRecommendResponse(Coach coach, List<Food> foods) {
        this.coach = coach;
        this.foods = foods;
    }

    public Coach getCoach() {
        return coach;
    }

    public List<Food> getFoods() {
        return foods;
    }
}
