package menu.coach;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    String name;
    List<String> foodNotEat;
    List<String> foodEaten;

    Coach(String name) {
        this.name = name;
        this.foodNotEat = new ArrayList<>();
        this.foodEaten = new ArrayList<>();
    }
}
