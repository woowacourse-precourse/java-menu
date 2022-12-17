package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.utils.Category;

import java.util.ArrayList;
import java.util.List;

public class PickMenu {
    private final List<Category> categories;
    private static final int MIN_CATEGORY_NUMBER = 1;
    private static final int MAX_CATEGORY_NUMBER = 5;

    public PickMenu() {
        this.categories = getRandomCategory();
    }

    private List<Category> getRandomCategory() {
        List<Category> makeCategory = new ArrayList<>();
        for (int i = 0; i < MAX_CATEGORY_NUMBER; i++) {
            Category category = Category.valueOfPickNumber(Randoms.pickNumberInRange(MIN_CATEGORY_NUMBER,MAX_CATEGORY_NUMBER));
            makeCategory.add(category);
        }
        return makeCategory;
    }
}
