package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private final List<Menu> banFoods;

    private List<Menu> recommendMenu = new ArrayList<>();

    public Coach(String name, List<Menu> banFoods) {
        this.name = name;
        this.banFoods = banFoods;
    }

    public void addMenu(Menu menu) {
        recommendMenu.add(menu);
    }

    public boolean canEat(Menu menu) {
        return !banFoods.contains(menu);
    }

    public boolean hasNotSameMenu(Menu menu) {
        return !recommendMenu.contains(menu);
    }

    public String getName() {
        return name;
    }

    public List<Menu> getRecommendMenu() {
        return recommendMenu;
    }
}
