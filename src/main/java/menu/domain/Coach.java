package menu.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Coach {

    private final String name;
    private final List<Menu> menuNotToEat = new ArrayList<>();
    private final List<Category> categoriesAlreadyEaten = new ArrayList<>();
    private final Map<Day, Menu> menuAlreadyEaten = new EnumMap<>(Day.class);

    public Coach(String name) {
        this.name = name;
    }

    public void addMenuNotToEat(List<Menu> menuNotToEat) {
        this.menuNotToEat.addAll(menuNotToEat);
    }

    public void addCategoriesAlreadyEaten(Category category) {
        categoriesAlreadyEaten.add(category);
    }

    public void addMenuAlreadyEaten(Day day, Menu menu) {
        menuAlreadyEaten.put(day, menu);
    }


    public boolean isAvailableMenu(Menu menu) {
        return isNotAlreadyEatenMenu(menu) && isNotMenuNotToEat(menu);
    }

    private boolean isNotAlreadyEatenMenu(Menu menu) {
        return !menuAlreadyEaten.containsValue(menu);
    }

    private boolean isNotMenuNotToEat(Menu menu) {
        return !menuNotToEat.contains(menu);
    }

    private int countCategoryOf(Category category) {
        return (int) categoriesAlreadyEaten.stream()
                .filter(element -> element == category).count();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public Map<Day, Menu> getMenuAlreadyEaten() {
        return menuAlreadyEaten;
    }
}
