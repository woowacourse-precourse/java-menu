package menu.domain;

import java.util.List;

public class Coach {

    private final String name;
    private final List<String> canNotEatMenus;

    public Coach(String name, List<String> canNotEatMenus) {
        this.name = name;
        this.canNotEatMenus = canNotEatMenus;
    }

}
