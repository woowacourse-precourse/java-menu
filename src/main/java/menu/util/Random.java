package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.food.Category;

import java.util.List;

public class Random {

    public static Category pickRandomCategory() {
        return Category.of(Randoms.pickNumberInRange(1, 5));
    }

    public static String pickRandomFood(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }
}
