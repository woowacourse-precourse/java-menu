package menu.dto;

import java.util.List;
import menu.domain.Category;

public class MenusDto {

    private final List<Category> categories;
    private final List<MenuDto> menus;

    public MenusDto(List<Category> categories, List<MenuDto> menus) {
        this.categories = categories;
        this.menus = menus;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<MenuDto> getMenus() {
        return menus;
    }
}
