package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Result {
    private List<String> selectedCategory;
    private Map<String, Integer> categoryCounts;
    private Map<String, ArrayList<String>> selectedMenu;

    public Result(List<String> selectedCategory, Map<String, Integer> categoryCounts, Map<String, ArrayList<String>> selectedMenu) {
        this.selectedCategory = selectedCategory;
        this.categoryCounts = categoryCounts;
        this.selectedMenu = selectedMenu;
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

    public List<String> checkSelectedMenu(String coachName) {
        return selectedMenu.get(coachName);
    }
}
