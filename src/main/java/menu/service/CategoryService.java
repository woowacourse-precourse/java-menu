package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.domain.Category;
import menu.domain.CategoryHistory;

public class CategoryService {
    private static final boolean SELECT_INVALID_CATEGORY = true;

    private CategoryHistory categoryHistory;

    public CategoryService(CategoryHistory categoryHistory) {
        this.categoryHistory = categoryHistory;
    }

    public Category selectCategory() {
        List<Category> selectedCategory = categoryHistory.getCategoryHistory();
        while (SELECT_INVALID_CATEGORY) {
            int categoryNumber = Randoms.pickNumberInRange(1, 5);
            Category category = Category.getCategoryByNumber(categoryNumber);

            long categoryCount = selectedCategory.stream()
                    .filter(c -> c.equals(category))
                    .count();

            if (categoryCount < 2) {
                return category;
            }
        }
    }
}
