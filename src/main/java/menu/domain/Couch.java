package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Couch {

    private final String name;
    private List<String> uneatableMenus;
    private List<String> eatenMenus = new ArrayList<>();

    private Couch(String name) {
        this.name = name;
    }

    public static Couch of(String name) {
        return new Couch(name);
    }

    public void setUneatableMenus(List<String> menus) {
        uneatableMenus = menus;
    }

    public String getName() {
        return name;
    }

    public List<String> getUneatableMenus() {
        return uneatableMenus;
    }

    public List<String> getEatenMenus() {
        return eatenMenus;
    }

    public boolean validateMenu(String selectedMenu) {
        if (validateUneatableMenu(selectedMenu) && validateEatenMenu(selectedMenu)) {
            return true;
        }
        return false;
    }

    private boolean validateUneatableMenu(String selectedMenu) {
        if (uneatableMenus.contains(selectedMenu)) {
            return false;
        }
        return true;
    }

    private boolean validateEatenMenu(String selectedMenu) {
        if (eatenMenus.contains(selectedMenu)) {
            return false;
        }
        return true;
    }

    public void addMenu(String selectedMenu) {
        eatenMenus.add(selectedMenu);
    }
}
