package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.Couch;
import menu.domain.Food;

import java.util.ArrayList;
import java.util.List;

public class RecommendService {

    List<Category> categories = new ArrayList<>();

    public Category getCategory() {
        int i = Randoms.pickNumberInRange(1, 5);
        Category category = Category.from(i);
        if (isOutOfRange(category)) {
            return getCategory();
        }
        categories.add(category);
        return category;
    }

    private boolean isOutOfRange(Category from) {
        long count = categories.stream()
                .filter(stored -> stored == from)
                .count();
        return count > 2;
    }

    public Food getFood(Category category, Couch couch) {
        return Food.getFoodByCategoryAndCouch(category, couch);
    }
}
