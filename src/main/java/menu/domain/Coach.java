package menu.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Coach {
    private String name;
    private HashSet<String> hates;
    private List<String> meals = new ArrayList<>();

    public Coach(String name, HashSet<String> hates) {
        this.name = name;
        this.hates = hates;
    }

    public String getName() {
        return name;
    }

    public HashSet<String> getHates() {
        return hates;
    }

    public List<String> getMeals() {
        return meals;
    }

    public void addMeals(String menu) {
        this.meals.add(menu);
    }
}
