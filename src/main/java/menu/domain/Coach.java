package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private String name;

    private List<String> hateMenus;

    private List<String> completeMenus = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addHateMenus(List<String> hatingMenus) {
        hateMenus = hatingMenus;
    }
}
