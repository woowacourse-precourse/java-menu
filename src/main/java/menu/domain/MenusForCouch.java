package menu.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import menu.domain.Day;
import menu.domain.Menu;

public class MenusForCouch {

    private final String couchName;
    private final Map<Day, Menu> menuMap;


    public MenusForCouch(String couchName, Map<Day, Menu> menuMap) {
        this.couchName = couchName;
        this.menuMap = menuMap;
    }

    public String getCouchName() {
        return couchName;
    }

    public Menu getMenuOfDay(Day day) {
        return menuMap.get(day);
    }
}
