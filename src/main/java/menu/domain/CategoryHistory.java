package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class CategoryHistory {
    private List<Category> categoryHistory;

    public void addCategory() {
        categoryHistory.add(selectCategory());
    }

    public List<Category> getCategoryHistory() {
        return Collections.unmodifiableList(categoryHistory);
    }

    public Category selectCategory() {
        while (true) {
            int categoryNumber = Randoms.pickNumberInRange(1, 5);
            Category category = Category.getCategoryByNumber(categoryNumber);

            long categoryCount = categoryHistory.stream()
                    .filter(c -> c.equals(category))
                    .count();

            if (categoryCount < 2) {
                return category;
            }
        }
    }
}
