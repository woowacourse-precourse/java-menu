package menu.utils;

import camp.nextstep.edu.missionutils.Randoms;
import menu.enums.Category;

public class RandomUtils {

    public static Category pickCategoryInRandom() {
        return Category.selectCategoryByCode(Randoms.pickNumberInRange(1, 5));
    }
}
