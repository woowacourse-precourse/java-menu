package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuHistory {
    private final Map<Day, Menu> weekMenus;

    private MenuHistory(Map<Day, Menu> weekMenus) {
        this.weekMenus = weekMenus;
    }

    public void addMenuOfDay(Menu menu, Day day) {
        if(!hasMenu(menu)) {
            weekMenus.put(day, menu);
        }
    }
    public boolean hasMenu(Menu menu) {
        return weekMenus.containsValue(menu);
    }

    public List<Menu> getMenus() {
        List<Menu> menus = new ArrayList<>();
        for (Day day : Day.values()) {
            menus.add(weekMenus.get(day));
        }
        return menus;
    }
}
