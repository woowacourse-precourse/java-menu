package menu.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

}
