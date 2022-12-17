package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Categories;
import menu.domain.menu.FoodStyle;

public class CategoryGenerator {

    public void generateCategories(Categories categories) {
        makeCategory(categories);
    }

    public void makeCategory(Categories categories) {
        while (true) {
            FoodStyle foodStyle = FoodStyle.getFoodStyle(Randoms.pickNumberInRange(1, 5));
            if (categories.isFullOfCategory(foodStyle)) {
                continue;
            }
            categories.addCategory(foodStyle.getStyle());
            break;
        }
    }
}
