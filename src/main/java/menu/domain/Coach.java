package menu.domain;

import java.util.List;

public class Coach {
    private String name;
    private List<String> unableMenus;


    public Coach(String name, List<String> unableMenus) {
        this.name = name;
        this.unableMenus = unableMenus;
    }
    public String getName() {
        return name;
    }

}
