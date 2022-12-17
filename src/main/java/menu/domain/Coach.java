package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private final List<Menu> menuNotToEat = new ArrayList<>();
    private final List<Menu> menuAlreadyEaten = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public void addMenuNotToEat(List<Menu> menuNotToEat) {
        this.menuNotToEat.addAll(menuNotToEat);
    }


    public void addMenuAlreadyEaten(Menu menu) {
        menuAlreadyEaten.add(menu);
    }

    public boolean isAvailableMenu(Menu menu) {
        return isNotAlreadyEatenMenu(menu) && isNotMenuNotToEat(menu);
    }

    private boolean isNotAlreadyEatenMenu(Menu menu) {
        return !menuAlreadyEaten.contains(menu);
    }

    private boolean isNotMenuNotToEat(Menu menu) {
        return !menuNotToEat.contains(menu);
    }

    public String getName() {
        return name;
    }

    public List<Menu> getMenuAlreadyEaten() {
        return menuAlreadyEaten;
    }

    @Override
    public String toString() {
        return name;
    }

}
