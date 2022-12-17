package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Menus {

    private final List<String> menus = new ArrayList<>();

    public Menus(String menus) {
        splitMenus(menus);
    }

    private void splitMenus(String menus) {
        String[] splitMenus = menus.split(",");
        for (String splitMenu : splitMenus) {
            this.menus.add(splitMenu);
        }
    }

    public int size() {
        return menus.size();
    }
}
