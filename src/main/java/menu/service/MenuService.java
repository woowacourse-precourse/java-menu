package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MenuService {
    private final List<Category> pickedCategories = new ArrayList<>();

    private void pickCategories() {
        while(pickedCategories.size() < 5) {
            int order = Randoms.pickNumberInRange(1, 5);
            for (Category category : Category.values()) {
                addCategories(category, order);
            }

        }
    }

    private void addCategories(Category category, int order) {
        if (category.getOrder() == order && !checkCategoryPickedTwice(category)) {
            pickedCategories.add(category);
        }
    }

    private boolean checkCategoryPickedTwice(Category category) {
        int count = 0;
        for (Category pickedCategory : pickedCategories) {
            if (pickedCategory.equals(category)) {
                count++;
            }
        }
        return count == 2;
    }
}
