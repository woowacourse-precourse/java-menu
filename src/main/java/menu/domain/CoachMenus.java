package menu.domain;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.List;

public class CoachMenus {

    List<Menu> menus;

    public CoachMenus() {
        this.menus = new ArrayList<>();
    }

    public CoachMenus addMenu(Menu menu) {
        menus.add(menu);
        return this;
    }

    @Override
    public String toString() {
        return menus.stream()
                .map(menu -> menu.toString())
                .collect(joining(" | "));
    }
}
