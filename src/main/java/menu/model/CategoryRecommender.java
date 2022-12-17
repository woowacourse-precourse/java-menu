package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryRecommender {
    private List<Category> recommendedCategories = new ArrayList<>();

    public Category recommendCategory() {
        List<Category> categories = new ArrayList<>(List.of(Category.values()));
        Category category;
        while (true) {
            category = categories.get(Randoms.pickNumberInRange(1,5) - 1);
            if (Collections.frequency(recommendedCategories, category) > 2) {
                recommendedCategories.add(category);
                break;
            }
        }
        return category;
    }
}
