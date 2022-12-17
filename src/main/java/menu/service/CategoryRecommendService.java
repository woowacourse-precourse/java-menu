package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CategoryRecommendService {
    /**
     * 카테고리별 몇번 추천되었는지 횟수를 제공한다.
     */
    private static final Map<String, Integer> recommendCountByCategory = new HashMap<>();
    public static final int MAXIMUM_COUNT_LIMIT = 2;

    public static String recommendCategory() {
        String selectedCategory;
        do {
            selectedCategory = pickCategory();
        } while (isMaximumLimit(selectedCategory));
        return selectedCategory;
    }

    private static String pickCategory() {
        int categoryNumber = Randoms.pickNumberInRange(1, 5);
        return Arrays.asList("일식", "한식", "중식", "아시안", "양식").get(categoryNumber - 1);
    }

    /**
     * 카테고리에 대해 최대 횟수 이상 추천시 false 반환하고, 그렇지 않으면 추천횟수 증가 후 true 반환
     *
     * @param category 판단 원하는 카테고리
     * @return 최대 횟수 이상 추천여부
     */
    private static boolean isMaximumLimit(String category) {
        if (!recommendCountByCategory.containsKey(category)) {
            recommendCountByCategory.put(category, 0);
        }

        if (recommendCountByCategory.get(category) >= MAXIMUM_COUNT_LIMIT) {
            return true;
        }
        recommendCountByCategory.put(category, recommendCountByCategory.get(category) + 1);
        return false;
    }
}
