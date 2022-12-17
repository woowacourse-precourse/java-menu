package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.domain.Category;
import menu.domain.CategoryHistory;

public class CategoryService {

    private CategoryHistory categoryHistory;

    public Category selectCategory() {
        List<Category> selectedCategory = categoryHistory.getCategoryHistory();
        while (true) {
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
