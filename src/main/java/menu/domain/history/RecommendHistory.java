package menu.domain.history;

import menu.domain.category.Category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecommendHistory {

    private static final int CATEGORY_MAX = 2;
    private final List<Category> categories;

    public RecommendHistory() {
        this.categories = new ArrayList<>();
    }

    public boolean canRecommend(Category category) {
        return Collections.frequency(categories, category) <= CATEGORY_MAX;
    }
}
