package menu.domain;

import java.util.List;
import java.util.Map;

public class Result {
    private List<String> selectedCategory;
    private Map<String, Integer> categoryCounts;

    public Result(List<String> selectedCategory, Map<String, Integer> categoryCounts) {
        this.selectedCategory = selectedCategory;
        this.categoryCounts = categoryCounts;
    }

    public int checkCategoryCount(String categoryName) {
        return categoryCounts.get(categoryName);
    }

    public void addCategory(String categoryName) {
        this.selectedCategory.add(categoryName);
    }

    public void increaseCategoryCount(String categoryName) {
        this.categoryCounts.put(categoryName, categoryCounts.getOrDefault(categoryName, 0) + 1);
    }
}
