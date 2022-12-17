package menu.domain;

import java.util.Collections;
import java.util.List;

public class Coach {

    private final String name;
    private final List<String> cantEatMenu;

    public Coach(String name, List<String> cantEatMenu) {
        this.name = name;
        this.cantEatMenu = cantEatMenu;
    }

    public String getName() {
        return name;
    }

    public List<String> getCantEatMenu() {
        return Collections.unmodifiableList(cantEatMenu);
    }
}
