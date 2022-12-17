package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public void addMenu(String selectedMenu) {
        eatenMenus.add(selectedMenu);
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

    public void setUneatableMenus(List<String> menus) {
        validateDuplicateUneatableMenu(menus);
        uneatableMenus = menus;
    }

    private void validateDuplicateUneatableMenu(List<String> menus) {
        if (menus.size() != Set.of(menus).size()) {
            throw new IllegalArgumentException("[ERROR] 못먹는 음식은 중복하여 입력할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }


    public List<String> getEatenMenus() {
        return eatenMenus;
    }
}
