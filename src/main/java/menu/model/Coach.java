package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {

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

    public boolean cannotEatMenu(final String menu) {
        return cannotEatFoods.contains(menu) || alreadyEatFoods.contains(menu);
    }

    private static List<String> clone(final List<String> categoryMenus) {
        List<String> clone = new ArrayList<>();
        clone.addAll(categoryMenus);
        return clone;
    }

    public boolean validateMenu(final String menuName) {
        return alreadyEatFoods.contains(menuName);
    }
}
