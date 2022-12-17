package menu.repository;

import menu.domain.CATEGORY;
import menu.domain.MENU;
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
        for (String existMenu : menus.get(menuCategory)) {
            if (existMenu.equals(menu)) {
                return true;
            }
        }
        return false;
    }

    public static boolean menuExist(String menu) {
        for (MenuCategory menuCategory : menus.keySet()) {
            if (containsMenu(menu, menuCategory)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> getCategories() {
        return categories.stream()
                .map(MenuCategory::name)
                .collect(Collectors.toList());
    }

    public static MenuCategory getCategoryByName(String name) {
        for (MenuCategory menuCategory : categories) {
            if (name.equals(menuCategory.name())) {
                return menuCategory;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 카테고리입니다.");
    }

    public static List<String> getMenusOf(MenuCategory category) {
        return menus.get(category);
    }
}
