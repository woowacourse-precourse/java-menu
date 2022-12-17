package menu.domain;

import java.util.List;

public class CategoryHistory {
    private List<Category> categoryHistory;

    public void updateCategoryHistory(Category category) {
        categoryHistory.add(category);
    }
}
