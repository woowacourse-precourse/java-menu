package menu.domain;

import java.util.*;

public class Coach {
    String name;
    List<String> notEatFoods;

    public Coach(String name) {
        this.name = name;
        this.notEatFoods = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getNotEatFoods() {
        return notEatFoods;
    }

    public void addNotEatFood(String foodName) {
        this.notEatFoods.add(foodName);
    }
}
