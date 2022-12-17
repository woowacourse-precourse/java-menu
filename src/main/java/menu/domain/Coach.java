package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Coach {
    private final String name;
    private final List<Menu> noEatableMenus = new ArrayList<>();
    private final List<Menu> recommendMenus = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public void addNoEatableMenu(Menu menu) {
        noEatableMenus.add(menu);
    }

    public void addNoEatableMenuAll(List<Menu> menus) {
        noEatableMenus.addAll(menus);
    }

    public void addRecommendMenu(Menu menu) {
        recommendMenus.add(menu);
    }

    public String getName() {
        return name;
    }

    public boolean isEatable(Menu menu) {
        return !noEatableMenus.contains(menu);
    }

    public boolean isContainForRecommend(Menu menu) {
        return recommendMenus.contains(menu);
    }

    public List<String> getRecommendMenuNames() {
        return recommendMenus.stream().map(menu -> menu.getName()).collect(Collectors.toList());
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
        return Objects.equals(name, coach.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
