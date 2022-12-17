package menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> foods = new ArrayList<>();
    private final List<String> inedibleFoods = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void addFood(String food) {
        inedibleFoods.add(food);
    }

    public void recommendFood(String food) {
        foods.add(food);
    }

    public void addFoods(List<String> foods) {
        for (String food : foods) {
            addFood(food);
        }
    }

    public List<String> getFoods() {
        return foods;
    }

    public boolean contains(String food) {
        return foods.contains(food);
    }

    public boolean containsInedible(String food) {
        return inedibleFoods.contains(food);
    }
}
