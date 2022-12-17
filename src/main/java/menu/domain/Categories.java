package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.util.NumberGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Categories {
    private final List<Category> categories = Category.getCategories();
    HashMap<Category, Integer> categoryNum = new HashMap<>();
    private final List<Week> weeks = Week.getWeeks();
    private final NumberGenerator numberGenerator;


    Categories(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        for (Category category :
                categories) {
            categoryNum.put(category, 0);
        }
    }

    public List<Category> getRecommendCategory() {
        List<Category> recommendedCategories = new ArrayList<>();
        for (int i = 0; i < weeks.size(); i++) {
            Category category = categories.get(numberGenerator.generateCategoryIdx());
            if (categoryNum.get(category) == 2) {
                i--;
                continue;
            }
            recommendedCategories.add(category);
            categoryNum.put(category, categoryNum.get(category) + 1);
        }
        return recommendedCategories;
    }

}
