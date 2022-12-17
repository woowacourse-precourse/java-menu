package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Crew {
    private String name;
    private List<String> foods;

    public Crew(String name) {
        this.name = name;
        foods = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addFood(String name) {
        this.foods.add(name);
    }

    public boolean isAlreadyBeenFood(String foodName) {
        return foods.contains(foodName);
    }

    public boolean isDoneFillingFoods() {
        return foods.size() == 5;
    }
}
