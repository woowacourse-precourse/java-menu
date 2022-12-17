package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MenuRecommender {
    private List<Category> categoryHistory = new ArrayList<>();
    private List<String> coaches = new ArrayList<>();
    private static final List<Category> CATEGORIES = Arrays.asList(Category.values());

    private Category pickupCategory() {
        return CATEGORIES.get(Randoms.pickNumberInRange(1, 5));
    }

    private boolean validCategory(Category category) {
        return Collections.frequency(categoryHistory, category) == 3;
    }
}
