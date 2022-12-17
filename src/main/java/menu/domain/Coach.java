package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final CoachName name;
    private final List<String> canNotEatMenus = new ArrayList<>();

    public Coach(CoachName name) {
        this.name = name;
    }

    public void addCanNotEatMenus(List<String> menus) {
        canNotEatMenus.addAll(menus);
    }
}