package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RecommendSystem implements RandomPicker {

    private static final int FIRST_CATEGORY_NUMBER = 1;
    private static final int LAST_CATEGORY_NUMBER = 5;

    @Override
    public MenuCategory pickRandomCategory() {
        try {
            return pickCategory();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return pickRandomCategory();
        }
    }

    private static MenuCategory pickCategory() {
        final int categoryNumber = Randoms.pickNumberInRange(FIRST_CATEGORY_NUMBER, LAST_CATEGORY_NUMBER);
        return MenuCategory.pickCategory(categoryNumber);
    }

    @Override
    public List<String> pickRandomMenu(final MenuCategory category) {
        return null;
    }
}
