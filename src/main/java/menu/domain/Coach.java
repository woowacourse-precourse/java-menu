package menu.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Coach {
    private final String name;
    private final List<String> unEatableFood;
    private final Set<String> selectedMenus = new HashSet<>();
    private final Map<Category, Integer> categoryCounts = new HashMap<>();

    public Coach(String name, List<String> unEatableFood) {
        this.name = name;
        this.unEatableFood = unEatableFood;
        Arrays.stream(Category.values())
                .forEach(category -> categoryCounts.put(category, 0));
    }

    public Set<String> getSelectedMenus() {
        return selectedMenus;
    }

    public String getName() {
        return name;
    }


    public Map<Category, Integer> getCategoryCounts() {
        return categoryCounts;
    }

    public List<String> getUnEatableFood() {
        return unEatableFood;
    }
}
