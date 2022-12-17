package menu.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.condition.CoachCondition;
import menu.domain.initialdata.Day;
import menu.domain.initialdata.InitialMenu;
import menu.dto.RecommendationResultDto;

public class MenuRecommendation {
    private final RecommendedCategory recommendedCategory;
    private Map<Coach, CoachFood> coachFoods;

    public MenuRecommendation() {
        this.recommendedCategory = new RecommendedCategory();
        this.coachFoods = new LinkedHashMap<>();
    }

    public void initializeCoaches(List<String> coaches) {
        if (CoachCondition.isWrongCoachCount(coaches.size())) {
            throw new IllegalArgumentException("[ERROR] 함께 식사를 하는 코치 수는 2명에서 5명 사이여야 합니다.");
        }
        coaches.forEach(Coach::new);
    }

    public void initializeDislikeFoods(String coachName, List<String> dislikeFoods) {
        coachFoods.put(new Coach(coachName), new CoachFood(dislikeFoods));
    }

    public void recommendFood() {
        while (recommendedCategory.getCategories().size() < Day.getDays().size()) {
            recommendDailyFood();
        }
    }

    public List<RecommendationResultDto> getRecommendationResult() {
        return coachFoods.entrySet()
                .stream()
                .map(RecommendationResultDto::of)
                .collect(Collectors.toList());
    }

    public List<String> getRecommendedCategories() {
        return recommendedCategory.getCategories();
    }

    private void recommendDailyFood() {
        String category = recommendedCategory.pickRandomCategory();
        coachFoods.entrySet()
                .forEach(set -> recommendForEachCoach(set.getKey(), set.getValue(),
                        InitialMenu.getFoodsInCategory(category)));
    }

    private void recommendForEachCoach(Coach coach, CoachFood coachFood, List<String> foodsInCategory) {
        coachFood.updateRecommendedFood(foodsInCategory);
        coachFoods.put(coach, coachFood);
    }

}
