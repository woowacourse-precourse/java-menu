package menu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Menu;
import menu.format.ErrorFormat;

public class MenuRepository {

    private static Map<String, Menu> menuMap = new HashMap<>();

    public static Menu getMenusByName(String menu) {
        if(!menuMap.containsKey(menu) && menu.length() != 0){
            throw new IllegalArgumentException(ErrorFormat.INVALID_MENU_NAME.getMessage());
        }
        return menuMap.get(menu);
    }

    public static List<Menu> getMenusByCategory(Category category) {

        return menuMap.values().stream().filter((menu) -> menu.getCategory().equals(category))
                .collect(Collectors.toUnmodifiableList());
    }

    public static void addMenu(Menu menu) {
        menuMap.put(menu.getName(), menu);
    }
}
