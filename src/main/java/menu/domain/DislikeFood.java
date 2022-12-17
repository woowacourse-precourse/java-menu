package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.util.Constant;

public class DislikeFood {

    private final List<String> dislikeFood;

    public DislikeFood() {
        this.dislikeFood = new ArrayList<>();
    }

    public void addDislikeFood(String foodInput) {
        String[] foods = foodInput.split(Constant.INPUT_DELIMITER);

        dislikeFood.addAll(Arrays.asList(foods));
    }

    public List<String> getDislikeFood() {
        return dislikeFood;
    }
}
