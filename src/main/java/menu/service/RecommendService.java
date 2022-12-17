package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;
import menu.utils.Category;
import menu.utils.ErrorMessage;
import menu.utils.Food;
import menu.utils.Weekend;

import java.util.ArrayList;
import java.util.List;

public class RecommendService {

    List<Category> categories = new ArrayList<>();
    private static final int MAX_CATEGORY_STORAGE = 2;

    public Category getCategory() {
        validateCategory();
        int categoryCode = Randoms.pickNumberInRange(Category.MIN, Category.MAX);
        Category category = Category.from(categoryCode);
        categories.add(category);
        if (isOutOfRange(category)) {
            return getCategory();
        }
        return category;
    }

    private void validateCategory() {
        if (categories.size() > Weekend.size()) {
            throw new IllegalStateException(ErrorMessage.CATEGORY_TOO_MANY.getMessage());
        }
    }

    private boolean isOutOfRange(Category from) {
        long count = categories.stream()
                .filter(stored -> stored == from)
                .count();
        return count > MAX_CATEGORY_STORAGE;
    }

    public Food getFood(Category category, Coach coach) {
        List<String> foods = Food.getFoodByCategoryAndCouch(category, coach);
        String foodName = Randoms.shuffle(foods).get(0);
        return Food.from(foodName);
    }
}
