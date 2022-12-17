package menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> inedibleFoods = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public void addFood(String food) {
        inedibleFoods.add(food);
    }

    public void addFoods(List<String> foods) {
        for (String food : foods) {
            addFood(food);
        }
    }
}
