package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RecommendRepository {
    private final int TOTAL_DAY = 5;
    private List<String> categories;

    public RecommendRepository() {
        this.categories = new ArrayList<>();
    }

    public void recommendStart(CoachRepository coachRepository) {
        for (int day = 1; day <= TOTAL_DAY; day++) {
            int categoryNumber = 0;
            boolean doNotDecideNumber = true;

            while (doNotDecideNumber) {
                categoryNumber = Randoms.pickNumberInRange(1, 5);
                doNotDecideNumber = coachRepository.isNotPossibleCategory(Category.from(categoryNumber));
            }

            categories.add(Category.from(categoryNumber).toString());
            coachRepository.foodRecommendForDay(); // 여기서, 이제 recommend 하면 됨
        }
    }

    public List<String> getCategories() {
        return this.categories;
    }
}
