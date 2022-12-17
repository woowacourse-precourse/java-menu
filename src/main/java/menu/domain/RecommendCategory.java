package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class RecommendCategory {

    private final List<Category> recommendCategory = new ArrayList<>();

    public RecommendCategory() {

    }

    public boolean hasCategoryTwoMores(Category addCategory) {
        int count = 0;
        for (Category category : recommendCategory) {
            if (category.equals(addCategory)) {
                count ++;
            }
        }
        return count >= 2;
    }

    public void addCategory(Category category) {
        recommendCategory.add(category);
    }
}
