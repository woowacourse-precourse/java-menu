package menu.domain;

import java.util.List;
import menu.utils.Validation;

public class Coach {

    private final String name;
    private List<String> cantEatMenus;

    public Coach(String name) {
        Validation.isCoachName(name);
        this.name = name;
    }

    public void addCantEatMenus(List<String> cantEatMenus) {
        Validation.isMenus(cantEatMenus);
        this.cantEatMenus = cantEatMenus;
    }

    public String getName() {
        return name;
    }
}
