package menu.domain;

import java.util.List;

public class Coach {
    private final String name;
    private final List<Menu> excludeMenus;

    public Coach(String name, List<Menu> excludeMenus) {
        this.name = name;
        this.excludeMenus = excludeMenus;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                ", excludeMenus=" + excludeMenus +
                '}';
    }
}
