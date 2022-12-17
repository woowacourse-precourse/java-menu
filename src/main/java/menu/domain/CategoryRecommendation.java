package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CategoryRecommendation {
    private static final int INITIAL_INT_VALUE = 0;
    private static final int MAX_CATEGORY_RECOMMEND_COUNT = 2;
    private static final int MIN_CATEGORY_RANGE_NUMBER = 1;
    private static final int MAX_CATEGORY_RANGE_NUMBER = 5;

    private static List<FoodCategory> recommendations = new ArrayList<>();

    public static void recommendCategories() {
        for (int i = 0; i < 5; i++) {
            while (true) {
                FoodCategory pickedCategory = pickCategory();
                if (isContainingLessThanTwo(pickedCategory)) {
                    recommendations.add(pickedCategory);
                    break;
                }
            }
        }
    }

    private static FoodCategory pickCategory() {
        int number = Randoms.pickNumberInRange(MIN_CATEGORY_RANGE_NUMBER, MAX_CATEGORY_RANGE_NUMBER);
        for (FoodCategory foodCategory : FoodCategory.values()) {
            if (foodCategory.getNumber() == number) {
                return foodCategory;
            }
        }
        return null;
    }

    private static boolean isContainingLessThanTwo(FoodCategory pickedCategory) {
        int count = INITIAL_INT_VALUE;
        for (FoodCategory foodCategory : recommendations) {
            if (foodCategory == pickedCategory) {
                count++;
            }
        }
        if (count <= MAX_CATEGORY_RECOMMEND_COUNT) {
            return true;
        }
        return false;
    }

    public static List<FoodCategory> getRecommendations() {
        return recommendations;
    }
}
