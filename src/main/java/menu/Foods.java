package menu;

import java.util.List;

public class Foods {
    private final List<Food> foods;

    public Foods(List<Food> foods) {
        this.foods = foods;
    }

    public List<Food> foods() {
        return this.foods;
    }
}
