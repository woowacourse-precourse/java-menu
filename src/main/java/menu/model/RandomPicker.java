package menu.model;

import java.util.List;

public interface RandomPicker {
    MenuCategory pickRandomCategory();

    List<String> pickRandomMenu(final MenuCategory category);
}
