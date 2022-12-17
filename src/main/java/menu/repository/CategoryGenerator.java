package menu.repository;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Category;

public class CategoryGenerator {

    private static final int WEEKDAY_COUNT = 5;
    private static final int WEEKDAY_DUPLICATE_MAXIMUM = 2;

    private static final int MINIMUM_CATEGORY_CODE = 1;
    private static final int MAXIMUM_CATEGORY_CODE = 5;

    public static List<Category> createCategorys() {
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < WEEKDAY_COUNT; i++) {
            pickRandomCategory(categories);
        }
        return categories;
    }

    public static void pickRandomCategory(List<Category> categories) {
        while (true) {
            Category category = Category.findCategoryByCode(Randoms.pickNumberInRange(MINIMUM_CATEGORY_CODE, MAXIMUM_CATEGORY_CODE));
            if (Collections.frequency(categories, category) < WEEKDAY_DUPLICATE_MAXIMUM) {
                categories.add(category);
                return;
            }
        }
    }

}
