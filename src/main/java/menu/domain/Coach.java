package menu.domain;

import java.util.List;

public class Coach {

    private final String name;
    private final List<Menu> notEatFoods;

    public Coach(String name, List<Menu> notEatFoods) {
        this.name = name;
        this.notEatFoods = notEatFoods;
    }

    public boolean canNotEat(Menu menu) {
        return notEatFoods.contains(menu);
    }

    public String getName() {
        return name;
    }
}
