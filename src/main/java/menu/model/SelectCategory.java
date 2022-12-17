package menu.model;

import menu.constants.Category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectCategory {
    private static final int MAXIMUM_CATEGORY_FREQUENCY = 2;

    private final List<Category> selectCategories = new ArrayList<>();

    public void addCategory(Category category) {
        selectCategories.add(category);
    }

    public boolean isFrequencyMoreThanTwo(Category category) {
        return Collections.frequency(selectCategories, category) >= MAXIMUM_CATEGORY_FREQUENCY;
    }

    public List<Category> getSelectCategories() {
        return Collections.unmodifiableList(selectCategories);
    }
}
