package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Menu {

    private final String category;
    private final List<String> foods;


    public Menu(String category, List<String> foods) {
        this.category = category;
        this.foods = foods;
    }

    public String getCategory() {
        return category;
    }

    public String getFood() {
        return Randoms.shuffle(foods).get(0);
    }
}
