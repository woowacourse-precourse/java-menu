package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> cannotEatFoods = new ArrayList<>();
    private final List<String> alreadyEatFoods = new ArrayList<>();

    public Coach(final String name) {
        this.name = name;
    }

    public void addCannotEatFood(final List<String> foods) {
        cannotEatFoods.addAll(foods);
    }

    public void addAlreadyEatFood(final List<String> foods) {
        alreadyEatFoods.addAll(foods);
    }
}
