package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private String name;

    private List<String> hateMenus = new ArrayList<>();

    private List<String> completeMenus = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
