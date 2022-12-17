package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> inedibleFoods;

    public Coach(String name) {
        this.name = name;
        inedibleFoods = new ArrayList<>();
    }

    public void addInedibleFood(String foodName) {
        inedibleFoods.add(foodName);
    }

    public boolean isEdible(String foodName) {
        return inedibleFoods.stream().noneMatch(foodName::equals);
    }

    public String getName() {
        return name;
    }
}
