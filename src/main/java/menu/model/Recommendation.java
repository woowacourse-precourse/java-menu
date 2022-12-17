package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Recommendation {
    public List<Category> categories = new ArrayList<>();

    public Recommendation() {
        for (int i = 0; i < 5; i++) {
            Category categoryForDay = recommendCategoryForDay();
            categories.add(categoryForDay);
        }
    }

    private Category recommendCategoryForDay() {
        int alreadyCategoryCount;
        Category category;
        do {
            category = Category.getCategoryByNumber(Randoms.pickNumberInRange(1, 5));
            alreadyCategoryCount = countAlreadyRecommendedCategory(category);
        } while (alreadyCategoryCount >= 2);
        return category;
    }

    private int countAlreadyRecommendedCategory(Category finalCategory) {
        return (int) categories.stream()
                .filter(c -> c.equals(finalCategory))
                .count();
    }
}
