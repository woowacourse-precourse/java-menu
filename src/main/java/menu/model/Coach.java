package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> cantEats;
    private List<String> menu;

    public Coach(String name, List<String> cantEats) {
        this.name = name;
        this.cantEats = cantEats;
        this.menu = new ArrayList<>();
    }

    public List<String> getMenu() {
        return menu;
    }

    public void addMenu(String name) {
        this.menu.add(name);
    }

    public String getName() {
        return name;
    }

    public List<String> getCantEats() {
        return cantEats;
    }
}
