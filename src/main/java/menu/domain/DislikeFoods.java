package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.util.Constant;

public class DislikeFoods {

    private final List<String> dislikeFoods;

    public DislikeFoods() {
        this.dislikeFoods = new ArrayList<>();
    }

    public void addDislikeFood(String foodInput) {
        String[] foods = foodInput.split(Constant.INPUT_DELIMITER);

        dislikeFoods.addAll(Arrays.asList(foods));
    }

    public List<String> getDislikeFoods() {
        return dislikeFoods;
    }
}
