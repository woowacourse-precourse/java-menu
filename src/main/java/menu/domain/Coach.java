package menu.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import menu.domain.constant.Day;

public class Coach {
    private final String name;
    private final List<String> inedibleFoods;
    private final Map<Day, String> weeklyFoods;

    public Coach(String name) {
        this.name = name;
        this.inedibleFoods = new ArrayList<>();
        this.weeklyFoods = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public boolean isNameOf(String name) {
        return this.name.equals(name);
    }

    public void registerInedibleFoods(List<String> inedibleFoods) {
        this.inedibleFoods.addAll(inedibleFoods);
    }
}
