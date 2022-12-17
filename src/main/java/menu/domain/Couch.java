package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Couch {
    private final String name;
    private final List<Menu> hateMenus = new ArrayList<>();

    public Couch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
