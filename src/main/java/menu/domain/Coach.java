package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private List<Food> cannotEatFoods = new ArrayList<>();

    public Coach(String name, List<String> foods) {
        this.name = name;
        updateFoods(foods);
    }

    public void updateFoods(List<String> foods) {
        for (String name : foods) {
            cannotEatFoods.add(FoodRepository.getByName(name));
        }
    }
}
