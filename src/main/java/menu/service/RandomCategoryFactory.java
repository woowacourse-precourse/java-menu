package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;

public class RandomCategoryFactory {
    public static List<Category> randomCategory() {
        List<Category> categories = new ArrayList<>();
        while (categories.size() != 5) {
            Category category = Category.findCategory(Randoms.pickNumberInRange(1, 5));
            if (checkOverTwo(categories, category)) {
                continue;
            }
            categories.add(category);
        }
        return categories;
    }

    private static boolean checkOverTwo(List<Category> categories, Category randomCategory) {
        int i = 0;
        for (Category category : categories) {
            if (category == randomCategory) {
                i++;
            }
        }
        return i >= 2;
    }
}
