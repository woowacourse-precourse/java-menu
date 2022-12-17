package menu.domain;

import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Coach {

    private final String name;
    private final List<Food> inedibleFoods;

    public Coach(String name, List<Food> inedibleFoods) {
        this.name = name;
        this.inedibleFoods = inedibleFoods;
    }

    public String name() {
        return name;
    }

    public List<Food> inedibleFoods() {
        return unmodifiableList(inedibleFoods);
    }
}
