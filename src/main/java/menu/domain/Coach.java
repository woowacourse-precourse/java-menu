package menu.domain;

import java.util.List;

public class Coach {
    private final String name;
    private List<String> hateMenu;

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setHateMenu(List<String> hateMenu) {
        this.hateMenu = hateMenu;
    }
}
