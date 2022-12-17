package menu.dto;

import java.util.List;

public class MenusDto {

    private final List<MenuDto> menus;

    public MenusDto(List<MenuDto> menus) {
        this.menus = menus;
    }

    public List<MenuDto> getMenus() {
        return menus;
    }
}
