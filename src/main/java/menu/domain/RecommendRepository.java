package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecommendRepository {
    private static final int MAX_RECOMMEND_CATEGORY_NUMBER = 2;

    // 인덱스 0번은 리스트의 이름
    private static final List<String> categories = new ArrayList<>(List.of(Food.CATEGORY.getCategory()));

    public static List<String> recommendedCategories() {
        return Collections.unmodifiableList(categories);
    }

    public static void addCategory(String category) {
        categories.add(category);
    }

    public static boolean canRecommend(String category) {
        return Collections.frequency(categories, category) < MAX_RECOMMEND_CATEGORY_NUMBER;
    }

}
