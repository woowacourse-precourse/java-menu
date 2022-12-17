package menu.repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MenuByCategoryRepository {
    private static final Map<String, List<String>> menusByCategory = new LinkedHashMap<>();

    private MenuByCategoryRepository() {
    }

    public static void addMenuToMenu(String category, List<String> menuList) {
        menusByCategory.put(category, menuList);
    }

    public static Map<String, List<String>> findAll() {
        return menusByCategory;
    }

    public static List<String> findMenusBy(String category) {
        List<String> menus = menusByCategory.get(category);
        if (menus == null) {
            throw new IllegalArgumentException("카테고리 별 메뉴를 찾을 수 없습니다.");
        }
        return menus;
    }
}
