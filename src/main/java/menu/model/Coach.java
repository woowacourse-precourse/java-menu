package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> noEatFood;
    private List<String> ateFood;

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setNoEatFood(List<String> noEatFood) {
        this.noEatFood = noEatFood;
    }
}
