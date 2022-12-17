package menu.service;

import menu.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MenuService {
    private final List<Category> pickedCategories = new ArrayList<>();

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
