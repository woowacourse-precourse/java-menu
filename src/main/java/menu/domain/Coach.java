package menu.domain;

import java.util.*;

public class Coach {
    String name;
    List<String> notEatFoods;
    Set<String> alreadyEat;
    Map<Category, Integer> eatCountEachCategory;

    public Coach(String name) {
        this.name = name;
        this.notEatFoods = new ArrayList<>();
        this.alreadyEat = new HashSet<>();
        this.eatCountEachCategory = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getNotEatFoods() {
        return notEatFoods;
    }

    public Set<String> getAlreadyEat() {
        return alreadyEat;
    }

    public Map<Category, Integer> getEatCountEachCategory() {
        return eatCountEachCategory;
    }

    public void addNotEatFood(String foodName) {
        this.notEatFoods.add(foodName);
    }
}
