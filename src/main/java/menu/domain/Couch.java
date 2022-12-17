package menu.domain;

import menu.utils.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Couch {

    private final String name;
    private final List<Food> denied = new ArrayList<>();
    private final List<Food> recommend = new ArrayList<>();

    private Couch(String name) {
        String refined = name.trim();
        validateName(refined);
        this.name = refined;
    }

    private void validateName(String name) {
        if (isOutOfRange(name)) {
            throw new IllegalArgumentException(ErrorMessage.COUCH_NAME_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isOutOfRange(String name) {
        return name.length() < 2 || name.length() > 4;
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
