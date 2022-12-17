package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class MenuRepository {

    private static final List<Menu> menus = new ArrayList<>();

    public static Menu saveMenu(Category category, String[] menuList) {
        List<String> menuTempList = new ArrayList<>();
        boolean isFirst = true;
        for (String menu : menuList) {
            if (isFirst) {
                isFirst = false;
                continue;
            }
            menuTempList.add(menu);
        }
        Menu menu = new Menu(category, menuTempList);
        menus.add(menu);
        return menu;
    }

    public static void makeRandomMenuByCategory(Category category) {
        menus.stream().filter(menu -> menu.getCategory().equals(category))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    private List<String> findMenuByCategory() {
        return null;
    }
}
