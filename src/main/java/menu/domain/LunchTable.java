package menu.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LunchTable {
    private final Map<Day, Menu> menus;

    public LunchTable() {
        this.menus = new HashMap<>();
    }

    public Map<Day, Menu> getMenus() {
        return Collections.unmodifiableMap(menus);
    }

    public void put(Day day, Menu menu) {
        menus.put(day, menu);
    }

    public boolean isExist(Menu menu) {
        return menus.values()
                .stream()
                .anyMatch(coachMenu -> coachMenu.equals(menu));
    }
}
