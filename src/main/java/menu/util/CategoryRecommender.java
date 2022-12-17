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
            try {
                Category category = Category.from(Randoms.pickNumberInRange(1, 5));
                addCategory(categories, category);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return categories;
    }

    private static void addCategory(List<Category> categories, Category category) {
        if (!categories.contains(category)) {
            categories.add(category);
        }
    }
}
