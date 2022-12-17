package menu.repository;

import menu.domain.Category;
import menu.domain.MENU;
import menu.domain.menucategory.MenuCategory;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRepository {
    private final static List<MenuCategory> categories = List.of(new MenuCategory("일식"), new MenuCategory("한식"), new MenuCategory("중식"), new MenuCategory("아시안"), new MenuCategory("양식"));
    private final static HashMap<MenuCategory, List<String>> menus = new HashMap<>();

    static {
        menus.put(categories.get(Category.JAPANESE.order()), MENU.JAPANESE.value());
        menus.put(categories.get(Category.KOREAN.order()), MENU.KOREAN.value());
        menus.put(categories.get(Category.CHINESE.order()), MENU.CHINESE.value());
        menus.put(categories.get(Category.ASIAN.order()), MENU.ASIAN.value());
        menus.put(categories.get(Category.WESTERN.order()), MENU.WESTERN.value());
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
