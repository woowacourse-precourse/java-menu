package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coach {

    private final String name;
    private final UnavailableMenu unavailableMenu;
    private final RecommendMenu recommendMenu;

    private Coach(String name) {
        this.name = name;
        this.recommendMenu = new RecommendMenu();
        this.unavailableMenu = new UnavailableMenu();
    }

    public static Coach createCoach(String name) {
        return new Coach(name);
    }

    public String getName() {
        return name;
    }

    public void addUnavailableMenu(List<String> menus) {
        for (String menu : menus) {
            unavailableMenu.addMenu(menu);
        }
    }

    public boolean canNotEatMenu(String menu) {
        return unavailableMenu.hasMenu(menu);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return Objects.equals(name, coach.name) &&
                Objects.equals(unavailableMenu, coach.unavailableMenu) &&
                Objects.equals(recommendMenu, coach.recommendMenu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, unavailableMenu, recommendMenu);
    }
}
