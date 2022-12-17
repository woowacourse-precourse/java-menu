package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> hateFood;
    private List<String> eatenFood = new ArrayList<>();

    public Coach(String name, List<String> hateFood) {
        this.name = name;
        this.hateFood = hateFood;
    }

    public String pickFood(List<String> menus) {
        List<String> foods = new ArrayList<>(menus);
        String picked = Randoms.shuffle(foods).get(0);
        for (String hate : hateFood) {
            if (hate.equals(picked)) {
                return pickFood(menus);
            }
        }
        for (String eaten : eatenFood) {
            if (eaten.equals(picked)) {
                return pickFood(menus);
            }
        }
        eatenFood.add(picked);
        return picked;
    }
}
