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

    public List<String> getEatMenu() {
        return this.eatMenu;
    }

    public boolean newFood(String menu) {
        if (eatMenu.contains(menu)) {
            return false;
        }
        return true;
    }

    public boolean eatable(String menu) {
        if (noEatFood.contains(menu)) {
            return false;
        }
        return true;
    }
}
