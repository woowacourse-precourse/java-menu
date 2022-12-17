package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.enumeration.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecommandMachine {
    private static final Integer MAX_CATEGORY_COUNT = 5;
    private static final Integer MAX_EACH_CATEGORY_COUNT = 2;
    private static final Integer ZERO = 0;

    public List<CoachFoodRecommand> recommand(List<Coach> coaches) {
        CategoryRecommand categoryRecommand = recommandCategory();
        List<CoachFoodRecommand> foodRecommends = new ArrayList<>();
        for (Coach coach : coaches) {
            CoachFoodRecommand coachFoodRecommand = CoachFoodRecommand.recommandFood(coach, categoryRecommand);
            foodRecommends.add(coachFoodRecommand);
        }
        return foodRecommends;
    }

    private CategoryRecommand recommandCategory() {
        HashMap<String, Integer> categoryCount = new HashMap<>();
        List<String> categoryPerDay = new ArrayList<>();
        do {
            String category = Category.findCategoryName(Randoms.pickNumberInRange(1, 5));
            putCategory(category, categoryCount, categoryPerDay);
        } while (isContinuePutCategory(categoryCount));
        return new CategoryRecommand(categoryPerDay);
    }

    private boolean isContinuePutCategory(HashMap<String, Integer> categoryCount) {
        int sum = ZERO;
        for (Integer count : categoryCount.values()) {
            sum += count;
        }
        if (sum == MAX_CATEGORY_COUNT) {
            return false;
        }
        return true;
    }

    private void putCategory(String category, HashMap<String, Integer> categoryCount, List<String> categoryPerDay) {
        if (categoryCount.containsKey(category)) {
            int eachCategoryCount = categoryCount.get(category);
            categoryCount.put(category, eachCategoryCount + 1);
            categoryPerDay.add(category);
            checkCountRange(category, categoryCount, categoryPerDay);
            return;
        }
        categoryCount.put(category, 1);
        categoryPerDay.add(category);
    }

    private void checkCountRange(String category, HashMap<String, Integer> categoryCount, List<String> categoryPerDay) {
        int eachCategoryCount = categoryCount.get(category);
        if (categoryCount.get(category) > MAX_EACH_CATEGORY_COUNT) {
            categoryCount.put(category, eachCategoryCount - 1);
            categoryPerDay.remove(categoryPerDay.size() - 1);
        }
    }

}
