package menu.utils;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;

public class RandomCategory {
    public static Category getRandomCategory() {
        Category category = Category.get(Randoms.pickNumberInRange(1, 5));
        return category;
    }
}
