package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    public static final int CATEGORY_MAX_COUNT = 2;
    public static final int RECOMMEND_MENU_SIZE = 5;

    private final String name;
    private final List<Menu> banFoods;

    private List<Menu> recommendMenu = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();

    public Coach(String name, List<Menu> banFoods) {
        this.name = name;
        this.banFoods = banFoods;
    }

    public boolean canNotEat(Menu menu) {
        return banFoods.contains(menu);
    }

    public boolean hasMaxCategoryCount(Category inputCategory) {
        return categories.stream()
                .filter(category -> category.getName().equals(inputCategory.getName()))
                .count() >= CATEGORY_MAX_COUNT;
    }

    public boolean hasSameMenu(Menu menu) {
        return recommendMenu.contains(menu);
    }

    public boolean canReceiveMenu() {
        return recommendMenu.size() < RECOMMEND_MENU_SIZE;
    }
}
