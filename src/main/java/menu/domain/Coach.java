package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private List<String> forbiddenFoods;

    public Coach(String name, List<String> forbiddenFoods) {
        this.name = name;
        this.forbiddenFoods = forbiddenFoods;
    }

    public String getName() {
        return name;
    }

    public List<String> getForbiddenFoods() {
        return forbiddenFoods;
    }

}
