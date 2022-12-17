package domain;

import java.util.HashMap;
import java.util.Map;

public class CategoryDuplicationChecker {
    private Map<Category, Integer> categoryChecks;

    public CategoryDuplicationChecker() {
        categoryChecks = new HashMap<>();
    }

    public void increaseCategoryCount(Category category) {
        categoryChecks.merge(category, 1, (oldValue, newValue) -> oldValue + 1);
    }

    public boolean isUpperTwice(Category category) {
        if (categoryChecks.get(category) > 3) {
            return true;
        }
        return false;
    }
}
