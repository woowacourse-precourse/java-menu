package domain;

import java.util.HashMap;
import java.util.Map;

public class CategoryDuplicationChecker {
    private Map<Category, Integer> categoryChecks;

    public CategoryDuplicationChecker() {
        categoryChecks = new HashMap<>();
        for (Category category : Category.values()) {
            categoryChecks.put(category, 0);
        }
    }

    public void increaseCategoryCount(Category category) {
        categoryChecks.merge(category, 1, (oldValue, newValue) -> oldValue + 1);
    }

    public boolean isDuplicatedUpperTwice(Category category) {
        if (categoryChecks.get(category) > 3) {
            return true;
        }
        return false;
    }
}
