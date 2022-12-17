package menu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.domain.Coach;

public class CoachController {
    private List<Coach> coachs;
    private List<String> cantEatFoods;

    public CoachController() {
        this.coachs = new ArrayList<>();
        this.cantEatFoods = new ArrayList<>();
    }

    public List<Coach> makeCoachs(String coachNames) {
        String[] split = coachNames.split(",");
        for (String s : split) {
            coachs.add(new Coach(s));
        }

        return coachs;
    }

    public void setCantEatFood(List<String> cantEatFood) {
        for (int i = 0; i < coachs.size(); i++) {
            coachs.get(i).addCantEatFood(cantEatFood.get(i));
            addCatEatFoods(cantEatFood.get(i));
        }
    }

    public void addCatEatFoods(String cantEatFoods) {
        String[] split = cantEatFoods.split(",");
        this.cantEatFoods.addAll(Arrays.asList(split));
    }


    public List<Coach> getCoachs() {
        return coachs;
    }

    public List<String> getCantEatFoods() {
        return cantEatFoods;
    }
}
