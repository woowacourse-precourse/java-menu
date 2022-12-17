package menu.dto;

import java.util.List;
import menu.domain.Menu;

public class InvalidMenusDto {

    private final List<Menu> menus;

    public InvalidMenusDto(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
