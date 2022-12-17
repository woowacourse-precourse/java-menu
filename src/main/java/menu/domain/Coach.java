package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import menu.repository.MenuRepository;

public class Coach {

    String name;
    private final List<Menu> canNotEatMenu;

    public Coach(String name, List<String> canNotEatMenu) {
        this.name = name;
        this.canNotEatMenu = mapToMenus(canNotEatMenu);
    }

    private List<Menu> mapToMenus(List<String> canNotEatMenu) {
        List<Menu> menus = new ArrayList<>();
        for (String notEatMenu : canNotEatMenu) {
            Menu menu = MenuRepository.findByMenuName(notEatMenu);
            menus.add(menu);
        }
        return menus;
    }

    public String getName() {
        return name;
    }

    public List<Menu> getCanNotEatMenu() {
        return Collections.unmodifiableList(canNotEatMenu);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coach coach = (Coach) o;
        return Objects.equals(name, coach.name) && Objects.equals(canNotEatMenu,
            coach.canNotEatMenu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, canNotEatMenu);
    }
}
