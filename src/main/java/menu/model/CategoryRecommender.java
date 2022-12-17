package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryRecommender {
    public Category recommendCategory() {
        List<Category> categories = new ArrayList<>(List.of(Category.values()));
        Category category = categories.get(Randoms.pickNumberInRange(1,5) - 1);
        return category;
    }
}
