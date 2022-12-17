package menu.domain;

import java.util.List;

public class Coach {
    private final String name;
    private final List<Menu> excludeMenus;

    public Coach(String name, List<Menu> excludeMenus) {
        this.name = name;
        this.excludeMenus = excludeMenus;
    }

    public boolean isExcludeMenu(String menuName) {
        return excludeMenus.stream().anyMatch(m -> m.isSameMenu(menuName));
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name='" + name;
    }
}
