package menu.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectMenu {
    private final List<String> selectMenu = new ArrayList<>();

    public void addMenu(String menu) {
        selectMenu.add(menu);
    }

    public boolean isAlreadyExist(String menu) {
        return selectMenu.contains(menu);
    }

    public List<String> getSelectMenu() {
        return Collections.unmodifiableList(selectMenu);
    }
}
