package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuRecommendRepository {
    private static final int MAX_RECOMMEND_CATEGORY_NUMBER = 2;

    private static final List<String> recommendedCategories = new ArrayList<>();

    public static void recommend() {
        for (int time = 0; time < 5; time++) {
            MenuRecommendRepository.selectCategory();
            CoachRepository.selectMenu(recommendedCategories.get(time));
        }
    }
    public static void selectCategory() {
        String recommendedCategory;

        do {
            recommendedCategory = RandomGenerator.forCategory(Food.getCategories());
        } while (canRecommendCategory(recommendedCategory));

        recommendedCategories.add(recommendedCategory);
    }

    public static boolean canRecommendCategory(String category) {
        if (Collections.frequency(recommendedCategories, category) < MAX_RECOMMEND_CATEGORY_NUMBER) {
            return true;
        }
        return false;
    }

}
