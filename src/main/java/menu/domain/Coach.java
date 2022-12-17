package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private String name;
    private List<String> canNotEatFoods = new ArrayList<>();
    private List<String> recommendedCategory = new ArrayList<>();
    private List<String> recommendedMenu = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public List<String> getRecommendedCategory() {
        return recommendedCategory;
    }



}
