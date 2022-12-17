package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Menu {

    private static final List<Menu> cache = new ArrayList<>();
    private static final String NOT_FOUND_MENU = "존재하지 않는 메뉴입니다.";
    private final Category category;
    private final String name;

    private Menu(Category category, String name) {
        this.category = Objects.requireNonNull(category);
        this.name = name;
    }

    public static void initialize(Map<Category, List<String>> fileContent) {
        List<Menu> cacheContent = MenuFactory.getCache(fileContent);
        cache.addAll(cacheContent);
    }

    public static Menu valueOf(String name) {
        return cache.stream()
                .filter(menu -> name.equals(menu.name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_MENU));
    }

    public static List<Menu> getMenusOfCategory(Category category) {
        return cache.stream()
                .filter(menu -> category.equals(menu.category))
                .collect(Collectors.toUnmodifiableList());
    }

    public String getName() {
        return name;
    }

    private static class MenuFactory {
        static List<Menu> getCache(Map<Category, List<String>> fileContent) {
            List<Menu> cache = new ArrayList<>();
            fileContent.forEach(
                    (category, menus) -> cache.addAll(menusOfCategory(category, menus)));
            return cache;
        }

        private static List<Menu> menusOfCategory(Category category, List<String> menus) {
            return menus.stream()
                    .map(name -> new Menu(category, name))
                    .collect(Collectors.toList());
        }
    }

}
