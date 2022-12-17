package menu.domain.menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private final List<Food> forbiddenFood = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Food> getForbiddenFood() {
        return forbiddenFood;
    }
}
