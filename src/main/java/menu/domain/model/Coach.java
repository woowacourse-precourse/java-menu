package menu.domain.model;

import java.util.List;

public class Coach {

    private final String name;
    private final List<Menu> canNotEatFoods;

    public Coach(String name, List<Menu> canNotEatFoods) {
        this.name = name;
        this.canNotEatFoods = canNotEatFoods;
    }

    public boolean canEat(Menu menu) {
        return !canNotEatFoods.contains(menu);
    }
}
