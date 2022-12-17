package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coach {
    private String name;
    private List<String> foods = new ArrayList<>();

    private List<String> hateMenus = new ArrayList<>();

    public Coach(String name, List<String> hateMenus) {
        this.name = name;
        this.hateMenus = hateMenus;
    }

    public String getName() {
        return name;
    }

    public List<String> getFoods() {
        return Collections.unmodifiableList(foods);
    }

    public void addFood(String food) {
        foods.add(food);
    }

    public boolean isSameMenu(String randomFood) {
        return foods.contains(randomFood);
    }

    public boolean isHateMenu(String randomFood) {
        return hateMenus.contains(randomFood);
    }
}
