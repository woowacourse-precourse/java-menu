package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.enumeration.Category;

import java.util.HashMap;
import java.util.List;

public class RecommandMachine {
    private static final Integer MAX_CATEGORY_COUNT = 5;
    private static final Integer MAX_EACH_CATEGORY_COUNT = 2;
    private static final Integer ZERO = 0;

    public void recommand(List<Coach> coaches) {
        CategoryRecommand categoryRecommand = recommandCategory();

        for (Coach coach : coaches) {

        }
    }

    private CategoryRecommand recommandCategory() {
        HashMap<String, Integer> categoryCount = new HashMap<>();
        do {
            String category = Category.findCategoryName(Randoms.pickNumberInRange(1, 5));
            putCategory(category, categoryCount);
        } while(isContinuePutCategory(categoryCount));
        return new CategoryRecommand(categoryCount);
    }

    private boolean isContinuePutCategory(HashMap<String, Integer> categoryCount) {
        int sum = ZERO;
        for(Integer count : categoryCount.values()) {
            sum += count;
        }
        if (sum == MAX_CATEGORY_COUNT){
            return false;
        }
        return true;
    }

    private void putCategory(String category, HashMap<String, Integer> categoryCount) {
        if (categoryCount.containsKey(category)) {
            int eachCategoryCount = categoryCount.get(category);
            categoryCount.put(category, eachCategoryCount + 1);
            checkCountRange(category, categoryCount, eachCategoryCount);
            return;
        }
        categoryCount.put(category, 1);
    }

    private void checkCountRange(String category, HashMap<String, Integer> categoryCount, Integer eachCategoryCount) {
        if (categoryCount.get(category) > MAX_EACH_CATEGORY_COUNT) {
            categoryCount.put(category, eachCategoryCount - 1);
        }
    }

}
