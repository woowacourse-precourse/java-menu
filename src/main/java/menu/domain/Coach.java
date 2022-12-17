package menu.domain;

import menu.constants.CoachRules;
import menu.view.ErrorMessages;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> foods = new ArrayList<>();
    private final List<String> inedibleFoods = new ArrayList<>();

    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < CoachRules.MIN_NAME_LENGTH.getValue() || name.length() > CoachRules.MAX_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.COACH_NAME.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public void addInedibleFood(String food) {
        inedibleFoods.add(food);
    }

    public void recommendFood(String food) {
        foods.add(food);
    }

    public void addInedibleFoods(List<String> inedibleFoods) {
        for (String food : inedibleFoods) {
            addInedibleFood(food);
        }
    }

    public List<String> getFoods() {
        return foods;
    }

    public boolean contains(String food) {
        return foods.contains(food);
    }

    public boolean containsInedible(String food) {
        return inedibleFoods.contains(food);
    }
}
