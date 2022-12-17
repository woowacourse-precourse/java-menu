package menu.vo;

import java.util.List;

public class Coach {
    private final String name;
    private final List<String> menu;

    public Coach(String name, List<String> menu) {
        this.name = name;
        this.menu = menu;
    }
}
