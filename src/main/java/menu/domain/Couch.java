package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Couch {

    private String name;
    private List<String> cannotEatFoods = new ArrayList<>();
    private List<String> recommendedFoods = new ArrayList<>();

    public Couch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommendedFoods() {
        return recommendedFoods;
    }

    public void addRecommendedFood(String food) {
        recommendedFoods.add(food);
    }

    public List<String> getCannotEatFoods() {
        return cannotEatFoods;
    }

    public void setCannotEatFoods(List<String> cannotEatFoods) {
        this.cannotEatFoods = cannotEatFoods;
    }
}
