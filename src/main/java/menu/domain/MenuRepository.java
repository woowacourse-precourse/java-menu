package menu.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MenuRepository {
    private static final Map<Category, List<Menu>> menus = new HashMap<>();
    private static final Map<Coach, List<Menu>> bannedMenus = new HashMap<>();

    public static void save(Category category, List<String> menuNames) {
        List<Menu> menuArrays = menuNames.stream().map(Menu::new).collect(Collectors.toList());
        menus.put(category, menuArrays);
    }

    public static void saveBannedMenu(Coach coach, List<Menu> bannedMenusToSave) {
        bannedMenus.put(coach, bannedMenusToSave);
    }
}
