package menu.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class CategoryRecommendService {
    public static String recommendCategory() {
        String selectedCategory = pickCategory();
        return selectedCategory;
    }

    private static String pickCategory() {
        int categoryNumber = Randoms.pickNumberInRange(1, 5);
        return Arrays.asList("일식", "한식", "중식", "아시안", "양식").get(categoryNumber - 1);
    }
}
