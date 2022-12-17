package menu.domain;

import java.util.List;

public class Coach {
    private String name;
    private List<String> bannedMenu;

    public Coach(String name, List<String> bannedMenu) {
        this.name = name;
        this. bannedMenu = bannedMenu;
    }

    public boolean checkMenu(String menu) {
        return bannedMenu.contains(menu);
    }

    public String getName() {
        return name;
    }
}
