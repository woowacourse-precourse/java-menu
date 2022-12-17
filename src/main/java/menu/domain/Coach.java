package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.repository.FoodRepository;

public class Coach {
    private final String name;
    private List<Food> cannotEatFoods = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public void updateFoods(List<String> foods) {
        for (String name : foods) {
            cannotEatFoods.add(FoodRepository.getByName(name));
        }
    }

    public String getName() {
        return name;
    }

    public boolean hasSameName(String name) {
        return this.name.equals(name);
    }

    public List<Food> getCannotEatFoods() {
        return Collections.unmodifiableList(cannotEatFoods);
    }
}
