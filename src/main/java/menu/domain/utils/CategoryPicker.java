package menu.domain.utils;

import menu.domain.Category;

public class CategoryPicker {

    private static final int START = 1;
    private static final int END = 5;
    private final pick pick;

    public CategoryPicker(final pick pick) {
        this.pick = pick;
    }

    public Category pickCategory() {
        return Category.findCategory(pick.pickNumberInRange(START, END));
    }
}