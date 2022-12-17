package menu.model;

import java.util.List;

public interface RandomPicker {
    List<MenuCategory> pickRandomCategory();

    String pickRandomMenu(List<String> menus, Coach coach);
}
