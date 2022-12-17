package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> myMenu = new ArrayList<>();
    private List<String> noMenu;

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getMyMenu() {
        return myMenu;
    }

    public List<String> getNoMenu() {
        return noMenu;
    }

    public void setNoMenu(List<String> noMenu) {
        this.noMenu = noMenu;
    }
}
