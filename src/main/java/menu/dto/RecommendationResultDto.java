package menu.dto;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import menu.domain.Coach;
import menu.domain.CoachFood;

public class RecommendationResultDto {
    private String coach;
    private List<String> foods;

    private RecommendationResultDto(String name, List<String> foods) {
        this.coach = name;
        this.foods = foods;
    }

    public static RecommendationResultDto of(Entry<Coach, CoachFood> coachWithFood) {
        return new RecommendationResultDto(coachWithFood.getKey().getName(), coachWithFood.getValue().getRecommendedFoods());
    }

    public String getCoach() {
        return coach;
    }

    public List<String> getFoods() {
        return foods;
    }
}
