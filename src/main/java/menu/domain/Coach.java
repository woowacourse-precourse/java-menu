package menu.domain;

import java.util.Collections;
import java.util.List;

public class Coach {

    private final String name;
    private final List<String> cantEatMenu;
    private List<String> eatMenu;

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

    public void setEatMenu(List<String> eatMenu) {
        this.eatMenu = eatMenu;
    }

    public List<String> getEatMenu() {
        return Collections.unmodifiableList(eatMenu);
    }
}
