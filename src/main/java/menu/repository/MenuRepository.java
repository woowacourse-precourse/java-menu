package menu.repository;

import menu.domain.source.CATEGORY;
import menu.domain.source.MENU;
import menu.domain.menucategory.MenuCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRepository {
    private final static List<MenuCategory> categories = new ArrayList<>();
    private final static HashMap<MenuCategory, List<String>> menus = new HashMap<>();

    static {
        initCategories();
        menus.put(categories.get(CATEGORY.JAPANESE.order()), MENU.JAPANESE.value());
        menus.put(categories.get(CATEGORY.KOREAN.order()), MENU.KOREAN.value());
        menus.put(categories.get(CATEGORY.CHINESE.order()), MENU.CHINESE.value());
        menus.put(categories.get(CATEGORY.ASIAN.order()), MENU.ASIAN.value());
        menus.put(categories.get(CATEGORY.WESTERN.order()), MENU.WESTERN.value());
    }

    private static void initCategories() {
        for (CATEGORY category : CATEGORY.values()) {
            categories.add(MenuCategory.from(category.getName()));
        }
    }

    private static boolean containsMenu(String menu, MenuCategory menuCategory) {
        return menus.get(menuCategory)
                .stream()
                .anyMatch(menu::equals);
    }

    public static boolean menuExist(String menu) {
        return menus.keySet()
                .stream()
                .anyMatch(menuCategory -> containsMenu(menu, menuCategory));
    }

    public static List<String> getCategories() {
        return categories.stream()
                .map(MenuCategory::name)
                .collect(Collectors.toList());
    }

    public static MenuCategory getCategoryByName(String name) {
        return categories.stream()
                .filter(category -> name.equals(category.name()))
                .findFirst()
                .get();
    }

    public static List<String> getMenusOf(MenuCategory category) {
        return menus.get(category);
    }
}
