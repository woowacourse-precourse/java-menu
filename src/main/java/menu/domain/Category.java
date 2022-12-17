package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<String> foods;

    public Category(String name) {
        this.name = name;
        this.foods = new ArrayList<>();
    }

    public void addCategoryFood(List<String> foods) {
        this.foods = foods;
    }

    public String getName() {
        return name;
    }

    public List<String> getFoods() {
        return foods;
    }
}
