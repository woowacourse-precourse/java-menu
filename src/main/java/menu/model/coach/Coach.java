package menu.model.coach;

import menu.model.Category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coach {

    private String name;
    private List<String> cannotEatFoods;
    private List<String> alreadyEatenFoods = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }
    public boolean isEqualCoach(String coachName) {
        return this.name.equals(coachName);
    }

    public void updateCannotEatFoods(List<String> cannotEatFoods) {
        this.cannotEatFoods = cannotEatFoods;
    }

    public void updateAlreadyEatFood(String menu) {
        alreadyEatenFoods.add(menu);
    }

    public boolean validateRecommendMenu(String recommendMenu) {
        boolean canRecommendMenuEat = true;
       if (isCannotEatFood(recommendMenu)) {
           canRecommendMenuEat = false;
       }
       if (isAlreadyEat(recommendMenu)) {
            canRecommendMenuEat = false;
       }
       return canRecommendMenuEat;
    }

    private boolean isCannotEatFood(String recommendMenu) {
        return cannotEatFoods.contains(recommendMenu);
    }

    private boolean isAlreadyEat(String recommendFood) {
        return alreadyEatenFoods.contains(recommendFood);
    }

    public List<String> getAlreadyEatenFoodsForPrint() {
        alreadyEatenFoods.add(0, name);
        return Collections.unmodifiableList(alreadyEatenFoods);
    }
}
