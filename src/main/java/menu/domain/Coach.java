package menu.domain;

import java.util.Collections;
import java.util.List;

public class Coach {

    private final String name;
    private List<String> cantEatMenu;
    private List<String> eatMenu;

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCantEatMenu(List<String> cantEatMenu) {
        this.cantEatMenu = cantEatMenu;
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
