package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class CategoryResult {
    private List<Category> categoryResults = new ArrayList<>();

    public boolean isPossible(Category category) {
        int sameCount = 0;
        for (Category categoryResult : categoryResults) {
            if (categoryResult.equals(category)) {
                sameCount++;
            }
        }
        return 2 < sameCount;
    }

    public void add(Category category) {
        categoryResults.add(category);
    }
}
