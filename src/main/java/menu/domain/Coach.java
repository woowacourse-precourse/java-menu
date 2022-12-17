package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coach {

    private String name;
    private List<String> dislikeFood;

    public Coach(String name) {
        this.name = name;
        this.dislikeFood = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getDislikeFood() {
        return dislikeFood;
    }

    public void addDislikeFood(String foodInput) {
        String[] foods = foodInput.split(",");

        dislikeFood.addAll(Arrays.asList(foods));
    }
}
