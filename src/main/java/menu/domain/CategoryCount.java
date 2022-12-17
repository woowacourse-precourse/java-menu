package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class CategoryCount {

    private static final int NUMBER_OF_CATEGORY = 5;
    private final List<Integer> countsOfEatingEachCategory;

    public CategoryCount() {
        countsOfEatingEachCategory = new ArrayList<>();
        countsOfEatingEachCategory.add(null);

        for (int i = 0; i < NUMBER_OF_CATEGORY; i++) {
            countsOfEatingEachCategory.add(0);
        }
    }

    public boolean canEat(Category category) {
        int categoryCode = category.getCode();

        int countOfEating = countsOfEatingEachCategory.get(categoryCode);
        if (countOfEating >= 2) {
            return false;
        }

        countsOfEatingEachCategory.set(categoryCode, countOfEating + 1);
        return true;
    }

}
