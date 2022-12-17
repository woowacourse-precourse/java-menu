package menu.model.category;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomCategoryGenerator {
    private final int maxCountPerCategory;

    public RandomCategoryGenerator(int maxCountPerCategory) {
        this.maxCountPerCategory = maxCountPerCategory;
    }

    public List<Category> pickCategories(int num) {
        List<Category> randomCategoryList = new ArrayList<>();
        Map<Category, Integer> categoryCountMap = makeCategoryCountMap();

        for(int i = 0; i < num; i++) {
            Category category = Category.get(Randoms.pickNumberInRange(1, 5));
            if(categoryCountMap.get(category) == maxCountPerCategory) {
                i--;
                continue;
            }
            randomCategoryList.add(category);
            categoryCountMap.put(category, (categoryCountMap.get(category) + 1));
        }
        return randomCategoryList;
    }

    private Map<Category, Integer> makeCategoryCountMap() {
        Map<Category, Integer> categoryCountMap = new HashMap<>();
        List<Category> allCategories = Category.getValuesWithAscendingOrder();

        for(Category category: allCategories) {
            categoryCountMap.put(category, 0);
        }
        return categoryCountMap;
    }
}
