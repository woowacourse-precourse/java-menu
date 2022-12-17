package menu.domain;

import java.util.List;

public class CategoryMenu {
    private final Category category;
    private final List<String> menus;

    public CategoryMenu(Category category, List<String> menus) {
        this.category = category;
        this.menus = menus;
    }
}
