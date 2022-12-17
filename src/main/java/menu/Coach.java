package menu;

import menu.view.ErrorMessages;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> foods = new ArrayList<>();
    private final List<String> inedibleFoods = new ArrayList<>();
    private static final int NAME_MIN_LENGTH = 2;
    private static final int NAME_MAX_LENGTH = 4;

    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.NAME.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public void addFood(String food) {
        inedibleFoods.add(food);
    }

    public void recommendFood(String food) {
        foods.add(food);
    }

    public void addFoods(List<String> foods) {
        for (String food : foods) {
            addFood(food);
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
