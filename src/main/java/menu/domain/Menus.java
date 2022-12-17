package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Menus {
    private final List<Menu> menus = new ArrayList<>();

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public boolean contains(Menu menu) {
        return menus.contains(menu);
    }

    public boolean containFiveMenus() {
        return menus.size() == 5;
    }

    public boolean duplicatedCategory(Menu menu) {
        int count = (int) menus.stream()
                .filter(comparedMenu -> comparedMenu.isEqualCategory(menu.getCategory()))
                .count();
        return count >= 2;
    }

    @Override
    public String toString() {
        List<String> menuNames = menus.stream()
                .map(Menu::getName)
                .collect(Collectors.toList());

        return String.join(" | ", menuNames);
    }
}
