package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final List<Menu> menus;
    private final String name;

    public Coach(String name) {
        this.menus = new ArrayList<>();
        this.name = name;
    }
}
