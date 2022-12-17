package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private final List<String> hateMenu;

    public Coach(String name) {
        this.name = name;
        this.hateMenu = new ArrayList<>();
    }
}
