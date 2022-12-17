package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CategoryRecommendation {
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
        int number = Randoms.pickNumberInRange(1, 5);
        for (FoodCategory foodCategory : FoodCategory.values()) {
            if (foodCategory.getNumber() == number) {
                return foodCategory;
            }
        }
        return null;
    }

    private static boolean isContainingLessThanTwo(FoodCategory pickedCategory) {
        int count = 0;
        for (FoodCategory foodCategory : recommendations) {
            if (foodCategory == pickedCategory) {
                count = count + 1;
            }
        }
        if (count <= 1) {
            return true;
        }
        return false;
    }
}
