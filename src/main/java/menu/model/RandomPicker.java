package menu.model;

import java.util.List;

public interface RandomPicker {
    MenuCategory pickRandomCategory();

    String pickRandomMenu(List<String> menus, Coach coach);
}
