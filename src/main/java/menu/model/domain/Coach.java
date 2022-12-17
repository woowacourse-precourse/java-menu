package menu.model.domain;

import java.util.List;

public class Coach {
    private String name;
    private List<Food> cannotEatFoods;

    public Coach(String name, List<Food> cannotEatFoods) {
        this.name = name;
        this.cannotEatFoods = cannotEatFoods;
    }

    public List<Food> getCannotEatFoods() {
        return cannotEatFoods;
    }

    public String getName() {
        return name;
    }

    public void setCannotEatFoods(List<Food> cannotEatFoods) {
        this.cannotEatFoods = cannotEatFoods;
    }
}
