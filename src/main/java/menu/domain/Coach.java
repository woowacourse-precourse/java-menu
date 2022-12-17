package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coach {
    String name;
    List<String> cannotEatMenu;
    List<String> alreadyEatMenu;

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void initCannotEatMenu(List<String> cannotEatMenu) {
        this.cannotEatMenu = new ArrayList<>(cannotEatMenu);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return Objects.equals(name, coach.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

