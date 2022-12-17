package menu.domain;

public class CategoryPicker {

    private static final int CATEGORY_START = 1;
    private static final int CATEGORY_END = 5;
    private final Picker picker;

    public CategoryPicker(Picker picker) {
        this.picker = picker;
    }

    public Category pickCategory() {
        int picked = picker.pickNumberInRange(CATEGORY_START, CATEGORY_END);
        return Category.from(picked);
    }
}
