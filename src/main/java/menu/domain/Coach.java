package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private List<Menu> menuNotToEat = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public void addMenuNotToEat(List<Menu> menuNotToEat) {
        this.menuNotToEat.addAll(menuNotToEat);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
