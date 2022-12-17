package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.food.Category;

import java.util.List;

public class Random {

    public static final int START = 1;
    public static final int END = 5;

    public static Category pickRandomCategory() {
        return Category.of(Randoms.pickNumberInRange(START, END));
    }

    public static String pickRandomFood(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }
}
