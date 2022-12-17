package menu.repository;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Category;

public class CategoryGenerator {

    public static List<Category> createCategorys() {
        List<Category> categories = new ArrayList<>();
        for (int i=0; i<5; i++) {
            pickRandomCategory(categories);
        }
        return categories;
    }

    public static void pickRandomCategory(List<Category> categories) {
        while(true) {
            Category category = Category.findCategoryByCode(Randoms.pickNumberInRange(1, 5));
            if (Collections.frequency(categories, category) < 2) {
                categories.add(category);
                return;
            }
        }
    }

}
