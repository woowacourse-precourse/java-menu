package menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private final List<Menu> hateMenus = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public void addHateMenu(Menu menu) {
        hateMenus.add(menu);
    }

    public String getName() {
        return name;
    }
}
