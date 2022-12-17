package menu.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class MenuHistory {
    private final Map<Day, Menu> weekMenus;

    public MenuHistory() {
        this.weekMenus = new EnumMap<>(Day.class);
    }

    public void addMenuOfDay(Menu menu, Day day) {
        if(!contains(menu)) {
            weekMenus.put(day, menu);
        }
    }
    public boolean contains(Menu menu) {
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
