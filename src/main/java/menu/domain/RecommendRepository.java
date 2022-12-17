package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecommendRepository {
    private static final int MAX_RECOMMEND_CATEGORY_NUMBER = 2;
    private static final List<String> categories = new ArrayList<>(List.of(Food.CATEGORY.getCategory()));

    public static List<String> recommendedCategories() {
        return Collections.unmodifiableList(categories);
    }

    public static void addCategory(String category) {
        categories.add(category);
    }

    public static boolean canRecommend(String category) {
        if (Collections.frequency(categories, category) < MAX_RECOMMEND_CATEGORY_NUMBER) {
            return true;
        }
        return false;
    }

}
