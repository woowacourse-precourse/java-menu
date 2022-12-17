package menu.domain.model;

import java.util.List;

public class Coach {

    private final String name;
    private final List<Food> forbiddenFood;

    public Coach(String name, List<Food> forbiddenFood) {
        this.name = name;
        this.forbiddenFood = forbiddenFood;
    }

    public String getName() {
        return name;
    }

    public List<Food> getForbiddenFood() {
        return forbiddenFood;
    }
}
