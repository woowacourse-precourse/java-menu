package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> noEatFood;
    private List<String> ateFood;

    public Coach(String name) {
        this.name = name;
        this.noEatFood = new ArrayList<>();
        this.ateFood = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }
}
