package menu.utils;

import camp.nextstep.edu.missionutils.Randoms;
import menu.enums.Category;

import java.util.List;

public class RandomUtils {

    public static int pickCategoryNumberInRandom() {
        return Randoms.pickNumberInRange(1, 5);
    }

    public static String pickFoodNameInShuffle(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }
}
