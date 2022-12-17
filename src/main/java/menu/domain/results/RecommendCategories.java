package menu.domain.results;

import java.util.ArrayList;
import java.util.List;
import menu.domain.menu.MenuCategory;

public class RecommendCategories {
    private static final int MAX_DUPLICATION_AMOUNT = 1;
    private static final int CATEGORY_MAX_SIZE = 5;

    private final List<MenuCategory> categories = new ArrayList<>();

    public void addRecommendCategory(MenuCategory menuCategory) {
        if (isAddable(menuCategory)) {
            categories.add(menuCategory);
        }
    }

    public boolean isFull() {
        return categories.size() == CATEGORY_MAX_SIZE;
    }

    private boolean isAddable(MenuCategory menuCategory) {
        long existCount = categories.stream()
                .filter(existCategory -> existCategory == menuCategory)
                .count();

        return existCount <= MAX_DUPLICATION_AMOUNT;
    }

    public List<MenuCategory> getCategories() {
        return categories;
    }
}
