package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private static final String SPLIT = ",";

    private String name;
    private List<String> canNotEatFoods = new ArrayList<>();
    private List<String> recommendedCategory = new ArrayList<>();
    private List<String> recommendedMenu = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    // 코치가 못 먹는 음식 추가
    public void saveCanNotEatFoods(String input) {
        String[] foods = input.split(SPLIT);
        for(String canNotEatFood : foods) {
            canNotEatFoods.add(canNotEatFood);
        }
    }

    public List<String> getRecommendedCategory() {
        return recommendedCategory;
    }

    public List<String> getRecommendedMenu() {
        return recommendedMenu;
    }

    public List<String> getCanNotEatFoods() {
        return canNotEatFoods;
    }



}
