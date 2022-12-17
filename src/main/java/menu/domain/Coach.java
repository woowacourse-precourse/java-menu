package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.util.Constant;

public class Coach {

    private String name;
    private List<String> dislikeFood;
    private List<String> recommendedMenus;

    public Coach(String name) {
        this.name = name;
        this.dislikeFood = new ArrayList<>();
        this.recommendedMenus = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getDislikeFood() {
        return dislikeFood;
    }

    public List<String> getRecommendedMenus() {
        return recommendedMenus;
    }

    public void addDislikeFood(String foodInput) {
        String[] foods = foodInput.split(Constant.INPUT_DELIMITER);

        dislikeFood.addAll(Arrays.asList(foods));
    }

    public void addRecommendedMenu(String menu) {
        recommendedMenus.add(menu);
    }
}
