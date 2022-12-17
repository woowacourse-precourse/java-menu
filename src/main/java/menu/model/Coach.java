package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private static final long MAX_RECOMMENDED_COUNT = 2L;

    private final String name;
    private final List<String> cannotEatFoods = new ArrayList<>();
    private final Menus alreadyEatFoods = new Menus();

    public Coach(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCannotEatFood(final Menus menus) {
        alreadyEatFoods.addMenus(menus);
    }

    public void addAlreadyEatFood(final List<String> foods) {
        cannotEatFoods.addAll(foods);
    }

    public boolean cannotEatMenu(final String menu) {
        return cannotEatFoods.contains(menu) || alreadyEatFoods.contains(menu);
    }

    public boolean isTooManySameCategory(final List<String> categoryMenus, final MenuCategory category) {
        return getDuplicateCategoryCount(categoryMenus) >= MAX_RECOMMENDED_COUNT;
    }

    private long getDuplicateCategoryCount(final List<String> categoryMenus) {
        final List<String> categoryMenusClone = clone(categoryMenus);
        final List<String> alreadyEatFoodsClone = alreadyEatFoods.getCloneMenus();

        categoryMenusClone.retainAll(alreadyEatFoodsClone);

        return categoryMenusClone.size();
    }

    private static List<String> clone(final List<String> categoryMenus) {
        List<String> clone = new ArrayList<>();
        clone.addAll(categoryMenus);
        return clone;
    }
}
