package menu.domain;

import java.util.HashMap;
import java.util.List;

public class MenuRecommendation {
    private final RecommendedCategory recommendedCategory;
    private HashMap<Coach, CoachFood> coachFoods;

    public MenuRecommendation() {
        this.recommendedCategory = new RecommendedCategory(); //생성하면서 카테고리 추천 완료
        this.coachFoods = new HashMap<>();
    }

    public void initializeCoaches(List<String> coaches) {
        if (CoachCondition.isWrongCoachCount(coaches.size())) {
            throw new IllegalArgumentException("[ERROR] 함께 식사를 하는 코치 수는 2명에서 5명 사이여야 합니다.");
        }
        coaches.forEach(this::initializeCoachFoods);
    }

    private void initializeCoachFoods(String coachName) {
        coachFoods.put(new Coach(coachName), new CoachFood());
    }
}
