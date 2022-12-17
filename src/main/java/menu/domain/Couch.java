package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Couch {

    private String name;
    private List<String> cannotEatFoods = new ArrayList<>();

    public Couch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getCannotEatFoods() {
        return cannotEatFoods;
    }

    public void setCannotEatFoods(List<String> cannotEatFoods) {
        this.cannotEatFoods = cannotEatFoods;
    }
}
