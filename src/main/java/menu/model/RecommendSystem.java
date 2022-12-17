package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RecommendSystem implements RandomPicker {

    private static final int FIRST_CATEGORY_NUMBER = 1;
    private static final int LAST_CATEGORY_NUMBER = 5;
    private static final String INITIAL_MENU = "";
    private static final int MAX_CATEGORY_SIZE = 5;

    @Override
    public List<MenuCategory> pickRandomCategory() {
        List<MenuCategory> categories = new ArrayList<>();

        while (categories.size() < MAX_CATEGORY_SIZE) {
            final MenuCategory category = pickCategory(categories);
            categories.add(category);
        }

        return categories;
    }

    private static MenuCategory pickCategory(final List<MenuCategory> categories) {
        final int categoryNumber = Randoms.pickNumberInRange(FIRST_CATEGORY_NUMBER, LAST_CATEGORY_NUMBER);
        final MenuCategory category = MenuCategory.pickCategory(categoryNumber);

        final long count = categories.stream()
                .filter(c -> c.equals(category))
                .count();

        if (count >= 2) {
            return pickCategory(categories);
        }

        return category;
    }

    @Override
    public String pickRandomMenu(final List<String> menus, final Coach coach) {
        String menu = INITIAL_MENU;
        boolean cannotEat = false;

        do {
            final List<String> shuffle = Randoms.shuffle(menus);
            menu = shuffle.get(0);
            cannotEat = coach.cannotEatMenu(menu);
        } while (cannotEat);

        return menu;
    }
}
