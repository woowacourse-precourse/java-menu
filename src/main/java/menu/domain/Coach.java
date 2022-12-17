package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Coach {
    private final String name;
    private List<String> hateMenus = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public void setHateMenus(List<String> hateMenus) {
        for (String hateMenu : hateMenus) {
            this.hateMenus.add(hateMenu);
        }
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
