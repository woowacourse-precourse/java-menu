package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Coach {
    private List<String> inedibleMenus = null;
    private String name;
    private List<String> menus = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public void addInedibleMenu(String inedibleMenu) {
        inedibleMenus = Arrays.stream(inedibleMenu.split(",")).collect(Collectors.toList());
    }

    public List<String> getInedibleMenus() {
        return inedibleMenus;
    }

    public String getName() {
        return name;
    }

    public boolean hasInedibleMenus() {
        return inedibleMenus != null;
    }

    public void addMenu(String menu) {
        menus.add(menu);
    }

    public List<String> getMenus() {
        return menus;
    }
}
