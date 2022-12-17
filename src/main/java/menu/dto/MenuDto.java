package menu.dto;

import java.util.List;

public class MenuDto {

    private final String name;
    private final List<String> menu;

    public MenuDto(String name, List<String> menu) {
        this.name = name;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public List<String> getMenu() {
        return menu;
    }
}
