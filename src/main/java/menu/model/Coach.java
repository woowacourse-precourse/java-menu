package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> noEatFood;
    private List<String> eatMenu;

    public Coach(String name) {
        this.name = name;
        this.eatMenu = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setNoEatFood(List<String> noEatFood) {
        this.noEatFood = noEatFood;
    }

    public void addFood(String food) {
        eatMenu.add(food);
    }
}
