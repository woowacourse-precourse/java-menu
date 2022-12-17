package menu.domain.coach;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> recommendedFoods = new ArrayList<>();
    private final List<String> doNotRecommendFoods = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addDoNotRecommendFood(String name) {
        doNotRecommendFoods.add(name);
    }

    public void recommendFood(String name) {
        recommendedFoods.add(name);
    }
}
