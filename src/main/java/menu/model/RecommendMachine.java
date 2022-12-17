package menu.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecommendMachine {
    private static final Integer MAX_RECOMMEND_CATEGORY_COUNT = 2;
    private static final Integer DAY_OF_SIZE = 5;
    public List<String> recommendCategory() {
        List<String> result = new ArrayList<>();
        while (result.size() <= DAY_OF_SIZE) {
            String recommending = Category.recommendCategory();
            if (canRecommend(result, recommending)) {
                result.add(recommending);
            }
        }
        return result;
    }

    public void recommendFood(Menu menu, String category) {
        String men = menu.recommendMenu(category);
    }

    private boolean canRecommend(List<String> category, String recommend) {
        return Collections.frequency(category, recommend) <= MAX_RECOMMEND_CATEGORY_COUNT;
    }
}
