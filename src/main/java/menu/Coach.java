package menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> hateFood;
    private List<String> eatenFood = new ArrayList<>();

    public Coach(String name, List<String> hateFood) {
        this.name = name;
        this.hateFood = hateFood;
    }
}
