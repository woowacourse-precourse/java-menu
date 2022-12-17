package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class UnavailableMenu {

    private final List<String> unavailableMenu;

    public UnavailableMenu() {
        this.unavailableMenu = new ArrayList<>();
    }

    public void addMenu(String menu) {
        unavailableMenu.add(menu);
    }
}
