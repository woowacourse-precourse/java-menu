package menu.domain;

import menu.domain.enums.Category;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private static final int MAX_DUPLICATED_COUNT = 2;

    private final String name;
    private final List<Menu> inedibleMenus;
    private final List<Menu> recommendedMenus = new ArrayList<>();

    public Coach(final String name, final List<Menu> inedibleMenus) {
        this.name = name;
        this.inedibleMenus = inedibleMenus;
    }

    public static Coach ofName(final String name) {
        return new Coach(name, new ArrayList<>());
    }

    public String name() {
        return name;
    }

    public List<Menu> recommendedMenus() {
        return recommendedMenus;
    }

    public boolean isDuplicatedCategory(final Category category) {
        long count = inedibleMenus.stream()
                .filter(it -> it.category().equals(category))
                .count();
        return MAX_DUPLICATED_COUNT <= count;
    }

    public boolean isEdible(final Menu menu) {
        return !inedibleMenus.contains(menu);
    }

    public void addInedibleMenus(final List<Menu> menus) {
        inedibleMenus.addAll(menus);
    }

    public void addRecommendedMenus(final Menu menu) {
        this.recommendedMenus.add(menu);
    }
}
