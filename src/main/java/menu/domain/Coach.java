package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private String forbiddenFood;
    private List<String> forbiddenFoods;

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getForbiddenFoods() {
        return forbiddenFoods;
    }

    public void setForbiddenFood(String forbiddenFood) {
        this.forbiddenFood = forbiddenFood;
    }

    private List<String> stringToList(String input) {
        List<String> foods = new ArrayList<>();
        String[] inputFoods = input.split(",");

        for (int i = 0; i < inputFoods.length; i++) {
            foods.add(inputFoods[i]);
        }

        return foods;
    }
}
