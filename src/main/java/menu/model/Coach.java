package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> cantEats;
    private List<String> menu = new ArrayList<>();

    public Coach(String name, List<String> cantEats) {
        this.name = name;
        this.cantEats = cantEats;
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
