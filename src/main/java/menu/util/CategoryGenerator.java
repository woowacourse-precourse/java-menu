package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Categories;
import menu.domain.menu.FoodStyle;

public class CategoryGenerator {
    private Categories categories = new Categories();

    public Categories generateCategories() {
        categories = new Categories();
        makeCategory();
        return categories;
    }

    public void makeCategory() {
        while (!categories.isDone()) {
            FoodStyle foodStyle = FoodStyle.getFoodStyle(Randoms.pickNumberInRange(1, 5));
            if (categories.isFullOfCategory(foodStyle)) {
                continue;
            }
            categories.addCategory(foodStyle.getStyle());
        }
    }
}
