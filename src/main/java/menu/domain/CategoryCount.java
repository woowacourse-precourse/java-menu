package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class CategoryCount {

    private static final int NUMBER_OF_CATEGORY = 5;
    private List<Integer> counts;

    public CategoryCount() {
        counts = new ArrayList<>();
        counts.add(null);

        for (int i = 0; i < NUMBER_OF_CATEGORY; i++) {
            counts.add(0);
        }
    }

    public boolean canEat(Category category) {
        int categoryCode = category.getCode();
        int countOfCategoryCode = counts.get(categoryCode);
        if (countOfCategoryCode >= 2) {
            return false;
        }

        counts.set(categoryCode, countOfCategoryCode + 1);
        return true;
    }

}
