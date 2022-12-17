package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Couch {

    private final String name;
    private final List<Food> denied = new ArrayList<>();
    private final List<Food> recommend = new ArrayList<>();

    private Couch(String name) {
        this.name = name;
    }

    public static Couch from(String name) {
        return new Couch(name);
    }

    public String getName() {
        return name;
    }

    public void denyFood(Food food) {
        denied.add(food);
    }

    public boolean isDeny(Food food) {
        return denied.contains(food);
    }

    public void eatFood(Food food) {
        recommend.add(food);
        denyFood(food);
    }

    public List<Food> getRecommend() {
        return Collections.unmodifiableList(recommend);
    }
}
