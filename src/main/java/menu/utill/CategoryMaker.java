package menu.utill;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;

public class CategoryMaker {
    private static List<String> categories = new ArrayList<>();

    public static List<String> make() {
        for (int i = 0; i < 5; i++) {
            inputCategory();
        }
        return categories;
    }

    private static void inputCategory() {
        while (true) {
            String category = Category.recommendKind();
            if (isInCategories(category)) {
                categories.add(category);
                break;
            }
        }

    }

    private static boolean isInCategories(String category) {
        int count = (int) categories.stream()
                .filter(ele -> ele.equals(category))
                .count();

        if (count < 2) {
            return true;
        }
        return false;
    }
}
