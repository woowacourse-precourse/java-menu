package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendRepository {
    private final int TOTAL_DAY = 5;
    private final RecommendMachine recommendMachine;
    private final Map<String, Integer> categoryFrequency;
    private List<String> categories;

    public RecommendRepository() {
        this.categories = new ArrayList<>();
        recommendMachine = new RecommendMachine();
        categoryFrequency = new HashMap<>();
        initCategoryFrequency();
    }

    private void initCategoryFrequency() {
        Arrays.stream(Category.values())
                .forEach(category -> categoryFrequency.put(category.toString(), 0));
    }

    public void recommendStart(CoachRepository coachRepository) {
        for (int day = 1; day <= TOTAL_DAY; day++) {
            int categoryNumber = 0;
            boolean doNotDecideNumber = true;
            while (doNotDecideNumber) {
                categoryNumber = Randoms.pickNumberInRange(1, 5);
                doNotDecideNumber = isNotPossible(Category.from(categoryNumber));
            }
            Category category = Category.from(categoryNumber);
            categories.add(category.toString());
            increaseCategoryFrequency(category);
            coachRepository.foodRecommendForDay(category, recommendMachine); // 여기서, 이제 recommend 하면 됨
        }
    }

    public boolean isNotPossible(Category category) {
        return !(categoryFrequency.get(category.toString()) < 2);
    }

    public void increaseCategoryFrequency(Category category) {
        categoryFrequency.put(category.toString(), categoryFrequency.get(category.toString()) + 1);
    }

    public List<String> getCategories() {
        return this.categories;
    }
}
