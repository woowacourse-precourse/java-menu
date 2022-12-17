package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class EatenMenu {
    private final List<String> eatenMenu = new ArrayList<>();

    public boolean isEdible(String menu) {
        return !eatenMenu.contains(menu);
    }

    public void add(String menu) {
        eatenMenu.add(menu);
    }

    public List<String> getEatenMenu() {
        return eatenMenu;
    }
}
