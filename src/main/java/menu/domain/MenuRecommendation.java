package menu.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.dto.RecommendationResultDto;

public class MenuRecommendation {
    private final RecommendedCategory recommendedCategory;
    private Map<Coach, CoachFood> coachFoods;

    public MenuRecommendation() {
        this.recommendedCategory = new RecommendedCategory(); //생성하면서 카테고리 추천 완료
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

    //모든 코치에 대해서 수행
    public void recommendFood() {
        coachFoods.entrySet()
                .forEach(set -> recommendFood(set.getKey(), set.getValue(), recommendedCategory.getAllFoodsInCategoryForWeek()));
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

    private List<List<String>> getRecommendedFood() {
        return coachFoods.values()
                .stream()
                .map(CoachFood::getRecommendedFoods)
                .collect(Collectors.toList());
    }

    //수행하고 업데이트
    private void recommendFood(Coach coach, CoachFood coachFood, List<List<String>> foodsInCategory) {
        coachFood.updateRecommendedFood(foodsInCategory);
        coachFoods.put(coach, coachFood);
    }

}
