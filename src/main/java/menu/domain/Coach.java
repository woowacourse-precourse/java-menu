package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Coach {
    private final String name;
    private final List<String> unEatableFood;
    private final List<String> selectedMenus = new ArrayList<>();

    public Coach(String name, List<String> unEatableFood) {
        this.name = name;
        this.unEatableFood = unEatableFood;
    }

    public List<String> getSelectedMenus() {
        return selectedMenus;
    }

    public String getName() {
        return name;
    }

    public List<String> getUnEatableFood() {
        return unEatableFood;
    }
}
