package menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;

import java.util.Collections;
import java.util.List;

public class CategoryRandomRecommender {

    private static final int RANDOM_LOWER_INCLUSIVE = 1;
    private static final int RANDOM_UPPER_INCLUSIVE = 5;

    public String recommend(List<String> categories) {
        String category = Category.values()[Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE) - 1]
                .getName();

        if (Collections.frequency(categories, category) > 2) {
            return recommend(categories);
        }

        return category;
    }
}
