package menu;

import menu.enums.Category;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class CategoryPicker {

    public static List<Category> pickMenuCategories() {
        List<Category> pickedCategories = new ArrayList<>();

        while (pickedCategories.size() < 5) {
            Category category = Category.getCategoryFromNumber(pickNumberInRange(1, 5));
            if (pickedCategories.stream().filter(c -> c == category).count() < 2) {
                pickedCategories.add(category);
            }
        }
        return pickedCategories;
    }
}
