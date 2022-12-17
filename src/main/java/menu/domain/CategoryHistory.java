package menu.domain;

import java.util.List;

public class CategoryHistory {
    private List<Category> categoryHistory;

    public void addCategory(Category category) {
        categoryHistory.add(category);
    }

    public List<Category> getCategoryHistory() {
        return categoryHistory;
    }
}
