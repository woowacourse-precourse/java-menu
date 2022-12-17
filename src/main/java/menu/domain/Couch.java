package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Couch {
    private final String name;
    private final List<Menu> hateMenus = new ArrayList<>();
    private final List<String> recommendsMenus = new ArrayList<>();

    public Couch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addHateMenu(Menu menu) {
        hateMenus.add(menu);
    }

    public boolean alreadyRecommend(String menu) {
        return recommendsMenus.contains(menu);
    }

    public void addRecommendMenu(String menu) {
        recommendsMenus.add(menu);
    }

    @Override
    public String toString() {
        return "Couch{" +
                "name='" + name + '\'' +
                ", hateMenus=" + hateMenus +
                '}';
    }

    public boolean isHateMenu(String offer) {
        return hateMenus.stream()
                .map(Menu::getName)
                .anyMatch(menu -> menu.equals(offer));
    }

    public List<String> getRecommendsMenus() {
        return List.copyOf(recommendsMenus);
    }
}
