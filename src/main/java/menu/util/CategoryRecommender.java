package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.Day;

import java.util.ArrayList;
import java.util.List;

public class CategoryRecommender {
    public static List<Category> recommendCategories() {
        List<Category> categories = new ArrayList<>();
        while (categories.size() < Day.values().length) {
            Category category = Category.from(Randoms.pickNumberInRange(1, 5));
            if (!categories.contains(category)) {
                categories.add(category);
            }
        }
        return categories;
    }
}
